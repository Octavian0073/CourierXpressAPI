package com.octa.courierXpress.service;

import com.octa.courierXpress.model.City;

import java.util.List;

public interface CityService {

    List<City> findAll();

    City findById(Long id);

    City findByCityName(String cityName);
}
