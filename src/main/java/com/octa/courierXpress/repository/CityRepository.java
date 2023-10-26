package com.octa.courierXpress.repository;

import com.octa.courierXpress.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
