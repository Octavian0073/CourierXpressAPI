package com.octa.courierXpress.controller;

import com.octa.courierXpress.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.octa.courierXpress.service.CityService;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getCities() {

        final List<City> cities = cityService.findAll();

        return cities;
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable final Long id) {

        City city = cityService.findById(id);

        return city;
    }

    @GetMapping("/name/{cityName}")
    public City getCityByName(@PathVariable final String cityName) {

        City city = cityService.findByCityName(cityName);

        return city;
    }
}
