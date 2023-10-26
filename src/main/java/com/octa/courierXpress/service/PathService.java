package com.octa.courierXpress.service;

import com.octa.courierXpress.model.Path;

import java.util.List;

public interface PathService {

    List<Path> findAll();

    Path findById(Long id);
}
