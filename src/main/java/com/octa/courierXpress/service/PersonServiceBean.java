package com.octa.courierXpress.service;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import com.octa.courierXpress.model.Person;
import com.octa.courierXpress.model.City;
import com.octa.courierXpress.model.Roles;
import com.octa.courierXpress.repository.CityRepository;
import com.octa.courierXpress.repository.PersonRepository;
import com.octa.courierXpress.repository.RolesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceBean implements PersonService {
    private final PersonRepository personRepository;
    private final CityRepository cityRepository;
    private final RolesRepository rolesRepository;

    public PersonServiceBean(PersonRepository personRepository, CityRepository cityRepository, RolesRepository rolesRepository) {
        this.personRepository = personRepository;
        this.cityRepository = cityRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public List<Person> findAll() { return personRepository.findAll(); }

    @Override
    public Person findById(Long id) { return personRepository.findById(id).get(); }

    @Transactional
    @Override
    public Person create(final Person person) {
        if (person.getId() != null) {
            throw new IllegalArgumentException("Cannot create new Person with the supplied id. The id attribute must be null to create an entity.");
        }

        Optional<City> optionalCity = cityRepository.findById(person.getInCity().getId());
        City city = optionalCity.orElse(null);
        Optional<Roles> optionalRole = rolesRepository.findById(person.getRole().getId());
        Roles role = optionalRole.orElse(null);

        person.setInCity(city);
        person.setRole(role);

        final Person savedPerson = personRepository.save(person);

        return savedPerson;
    }
}
