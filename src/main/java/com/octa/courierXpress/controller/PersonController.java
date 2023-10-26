package com.octa.courierXpress.controller;

import com.octa.courierXpress.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.octa.courierXpress.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> getPersons() {

        final List<Person> persons = personService.findAll();

        return persons;
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable final Long id) {

        Person person = personService.findById(id);

        return person;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody final Person person) {

        final Person savedPerson = personService.create(person);

        return savedPerson;
    }
}
