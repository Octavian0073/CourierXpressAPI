package com.octa.courierXpress.controller;

import com.octa.courierXpress.model.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.octa.courierXpress.service.PathService;

import java.util.List;

@RestController
@RequestMapping("/api/paths")
public class PathController {

    @Autowired
    private PathService pathService;

    @GetMapping
    public List<Path> getPaths() {

        final List<Path> paths = pathService.findAll();

        return paths;
    }

    @GetMapping("/{id}")
    public Path getPathById(@PathVariable final Long id) {

        Path path = pathService.findById(id);

        return path;
    }
}
