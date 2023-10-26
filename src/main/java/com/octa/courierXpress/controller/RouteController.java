package com.octa.courierXpress.controller;

import com.octa.courierXpress.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.octa.courierXpress.service.RouteService;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<Route> getRoutes() {

        final List<Route> routes = routeService.findAll();

        return routes;
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable final Long id) {

        Route route = routeService.findById(id);

        return route;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Route createRoute(@RequestBody final Route route) {

        final Route savedRoute = routeService.create(route);

        return savedRoute;
    }
}
