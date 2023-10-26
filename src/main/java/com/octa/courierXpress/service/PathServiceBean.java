package com.octa.courierXpress.service;

import com.octa.courierXpress.model.Path;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import com.octa.courierXpress.repository.CityRepository;
import com.octa.courierXpress.repository.PathRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PathServiceBean implements PathService {

    private final PathRepository pathRepository;

    private final CityRepository cityRepository;

    @Override
    public List<Path> findAll() { return pathRepository.findAll(); }

    @Override
    public Path findById(Long id) { return pathRepository.findById(id).get(); }

}
