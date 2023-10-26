package com.octa.courierXpress.controller;

import com.octa.courierXpress.model.Shipment;
import com.octa.courierXpress.model.ShipmentForUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.octa.courierXpress.service.ShipmentService;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping
    public List<Shipment> getShipments() {

        final List<Shipment> shipments = shipmentService.findAll();

        return shipments;
    }

    @GetMapping("/{id}")
    public Shipment getShipmentById(@PathVariable final Long id) {

        Shipment shipment = shipmentService.findById(id);

        return shipment;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shipment createShipment(@RequestBody final Shipment shipment) {

        final Shipment savedShipment = shipmentService.create(shipment);

        return savedShipment;
    }

    @PutMapping("/{id}")
    public Shipment updateShipment(@PathVariable("id") final Long shipmentId, @RequestBody final ShipmentForUpdateDTO shipmentForUpdateDTO) {

        return shipmentService.update(shipmentId, shipmentForUpdateDTO);
    }
}
