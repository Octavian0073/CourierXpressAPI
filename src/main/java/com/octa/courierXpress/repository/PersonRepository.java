package com.octa.courierXpress.repository;

import com.octa.courierXpress.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
