package com.octa.courierXpress.service;

import com.octa.courierXpress.model.Route;

import java.util.List;

public interface RouteService {

    List<Route> findAll();

    Route findById(Long id);

    Route create(Route route);
}
