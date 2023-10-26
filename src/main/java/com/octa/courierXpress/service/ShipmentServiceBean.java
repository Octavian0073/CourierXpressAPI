package com.octa.courierXpress.service;

import com.octa.courierXpress.model.Person;
import com.octa.courierXpress.model.Route;
import com.octa.courierXpress.model.Shipment;
import com.octa.courierXpress.model.ShipmentForUpdateDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import com.octa.courierXpress.repository.CityRepository;
import com.octa.courierXpress.repository.PersonRepository;
import com.octa.courierXpress.repository.RouteRepository;
import com.octa.courierXpress.repository.ShipmentRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ShipmentServiceBean implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    private final CityRepository cityRepository;

    private final PersonRepository personRepository;

    private final RouteRepository routeRepository;

    @Override
    public List<Shipment> findAll() { return shipmentRepository.findAll(); }

    @Override
    public Shipment findById(Long id) { return shipmentRepository.findById(id).get(); }

    @Override
    public Optional<Shipment> findOne(final Long id) {

        final Optional<Shipment> shipmentOptional = shipmentRepository.findById(id);

        return shipmentOptional;
    }

    @Transactional
    @Override
    public Shipment create(final Shipment shipment) {

        if (shipment.getId() != null) {
            throw new IllegalArgumentException("Cannot create new Person with the supplied id. The id attribute must be null to create an entity.");
        }

        Optional<Person> optionalSender = personRepository.findById(shipment.getSender().getId());
        Person sender = optionalSender.orElse(null);
        Optional<Person> optionalReceiver= personRepository.findById(shipment.getReceiver().getId());
        Person receiver= optionalReceiver.orElse(null);
        Optional<Route> optionalRoute= routeRepository.findById(shipment.getRoute().getId());
        Route route= optionalRoute.orElse(null);

        shipment.setSender(sender);
        shipment.setReceiver(receiver);
        shipment.setRoute(route);

        final Shipment savedShipment = shipmentRepository.save(shipment);

        return savedShipment;
    }

    @Transactional
    @Override
    public Shipment update(final Long shipmentId, final ShipmentForUpdateDTO shipmentForUpdateDTO ) {

        final Shipment shipmentToUpdate = findOne(shipmentId).orElseThrow(() -> new NoSuchElementException("Shipment not found"));

        if(shipmentForUpdateDTO.getCurrentCity() != null) {
            shipmentToUpdate.setCurrentCity(shipmentForUpdateDTO.getCurrentCity());
        }
        if(shipmentForUpdateDTO.getPackageStatus() != null) {
            shipmentToUpdate.setPackageStatus(shipmentForUpdateDTO.getPackageStatus());
        }
        if(shipmentForUpdateDTO.getReturnStarted() != null) {
            shipmentToUpdate.setReturnStarted(shipmentForUpdateDTO.getReturnStarted());
        }
        if(shipmentForUpdateDTO.getPackageReturned() != null) {
            shipmentToUpdate.setPackageReturned(shipmentForUpdateDTO.getPackageReturned());
        }

        final Shipment updatedShipment = shipmentRepository.save(shipmentToUpdate);

        return updatedShipment;
    }
}
