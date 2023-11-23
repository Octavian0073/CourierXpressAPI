package com.octa.courierXpress.service;

import com.octa.courierXpress.model.City;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.octa.courierXpress.repository.CityRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CityServiceBean implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<City> findAll() { return cityRepository.findAll(); }

    @Override
    public City findById(Long id) { return cityRepository.findById(id).get(); }

    @Override
    public City findByCityName(String cityName) { return cityRepository.findByCityName(cityName); }
}
