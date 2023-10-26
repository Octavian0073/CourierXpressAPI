package com.octa.courierXpress.service;

import com.octa.courierXpress.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    Person findById(Long id);

    Person create(Person person);
}
