package com.octa.courierXpress.service;

import com.octa.courierXpress.model.City;
import com.octa.courierXpress.model.Paths;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.octa.courierXpress.repository.CityRepository;
import com.octa.courierXpress.repository.PathRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PathServiceBean implements PathService {

    private final PathRepository pathRepository;

    private final CityRepository cityRepository;

    @Override
    public List<Paths> findAll() { return pathRepository.findAll(); }

    @Override
    public Paths findById(Long id) { return pathRepository.findById(id).get(); }

    @Override
    public List<Optional<City>> findRoutePath(Long idSrc, Long idDest) {
        int cities = cityRepository.findAll().size();
        List<Optional<City>> path = new ArrayList<>();

        List<Paths> paths = pathRepository.findAll();
        int[][] graph = graphFromPaths(paths, cities);

        List<Long> citiesIds = dijkstra(graph, idSrc, idDest, cities);

        citiesIds.forEach(cityId -> {
            cityId += 1;
            path.add(cityRepository.findById(cityId));
        });

        return path;
    }

    public int[][] graphFromPaths(List<Paths> paths, int cities) {

        int[][] graph = new int[cities][cities];

        paths.forEach(path -> {
            graph[path.getFromCity().getId().intValue() - 1][path.getToCity().getId().intValue() - 1] = path.getDistance().intValue();
            graph[path.getToCity().getId().intValue() - 1][path.getFromCity().getId().intValue() - 1] = path.getDistance().intValue();
        });

        return graph;
    }

    public int newMinDistance(int[] dist, Boolean[] sptSet, int cities) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i = 0; i < cities; i++)
            if(sptSet[i] == false && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        return minIndex;
    }

    public List<Long> dijkstra(int[][] graph, Long src, Long dest, int cities) {
        int[] dist = new int[cities];
        Boolean[] sptSet = new Boolean[cities];
        List<List<Long>> paths = new ArrayList<>();

        for(int i = 0; i < cities; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            paths.add(new ArrayList<>());
            paths.get(i).add(0L);
        }

        dist[src.intValue() - 1] = 0;

        for(int i = 0; i< cities - 1; i++) {
            int u = newMinDistance(dist, sptSet, cities);
            sptSet[u] = true;

            for(int v = 0; v < cities; v++)
                if(!sptSet[v] && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                    paths.set(v, new ArrayList<>(paths.get(u)));
                    paths.get(v).add((long) v);
                }
        }
        return paths.get(dest.intValue() - 1);
    }
}
