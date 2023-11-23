package com.octa.courierXpress.service;

import com.octa.courierXpress.model.City;
import com.octa.courierXpress.model.Paths;

import java.util.List;
import java.util.Optional;

public interface PathService {

    List<Paths> findAll();

    List<Optional<City>> findRoutePath(Long idSrc, Long idDest);

    Paths findById(Long id);
}
