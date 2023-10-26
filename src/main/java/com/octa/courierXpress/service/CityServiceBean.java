package com.octa.courierXpress.service;

import com.octa.courierXpress.model.City;
import org.springframework.stereotype.Service;
import com.octa.courierXpress.repository.CityRepository;

import java.util.List;

@Service
public class CityServiceBean implements CityService {

    private final CityRepository cityRepository;

    public CityServiceBean(CityRepository cityRepository) { this.cityRepository = cityRepository; }

    @Override
    public List<City> findAll() { return cityRepository.findAll(); }

    @Override
    public City findById(Long id) { return cityRepository.findById(id).get(); }
}
