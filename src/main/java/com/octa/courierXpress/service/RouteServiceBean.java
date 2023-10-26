package com.octa.courierXpress.service;

import jakarta.transaction.Transactional;
import com.octa.courierXpress.model.City;
import com.octa.courierXpress.model.Route;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import com.octa.courierXpress.repository.CityRepository;
import com.octa.courierXpress.repository.RouteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RouteServiceBean implements RouteService {

    private final RouteRepository routeRepository;

    private final CityRepository cityRepository;

    @Override
    public List<Route> findAll() { return routeRepository.findAll(); }

    @Override
    public Route findById(Long id) { return routeRepository.findById(id).get(); }

    @Transactional
    @Override
    public Route create(final Route route) {
        if (route.getId() != null) {
            throw new IllegalArgumentException("Cannot create new Person with the supplied id. The id attribute must be null to create an entity.");
        }

        Optional<City> optionalCityFrom = cityRepository.findById(route.getFromCity().getId());
        City from = optionalCityFrom.orElse(null);
        Optional<City> optionalCityTo = cityRepository.findById(route.getToCity().getId());
        City to = optionalCityTo.orElse(null);

        route.setFromCity(from);
        route.setToCity(to);

        final Route savedRoute = routeRepository.save(route);

        return savedRoute;
    }
}
