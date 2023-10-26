package com.octa.courierXpress.service;

import com.octa.courierXpress.model.Path;
import org.springframework.stereotype.Service;
import com.octa.courierXpress.repository.CityRepository;
import com.octa.courierXpress.repository.PathRepository;

import java.util.List;

@Service
public class PathServiceBean implements PathService {
    private PathRepository pathRepository;
    private CityRepository cityRepository;

    public PathServiceBean(PathRepository pathRepository, CityRepository cityRepository) {
        this.pathRepository = pathRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<Path> findAll() { return pathRepository.findAll(); }

    @Override
    public Path findById(Long id) { return pathRepository.findById(id).get(); }

}
