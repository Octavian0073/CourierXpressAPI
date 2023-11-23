package com.octa.courierXpress.controller;

import com.octa.courierXpress.model.City;
import com.octa.courierXpress.service.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paths")
public class PathController {

    @Autowired
    private PathService pathService;

    @GetMapping("/{idSrc}/{idDest}")
    public List<Optional<City>> getPathForRoute(@PathVariable final Long idSrc, @PathVariable final Long idDest) {

        List<Optional<City>> path = pathService.findRoutePath(idSrc, idDest);

        return path;
    }
}
