package com.octa.courierXpress.service;

import com.octa.courierXpress.model.Shipment;
import com.octa.courierXpress.model.ShipmentForUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {

    List<Shipment> findAll();

    Shipment findById(Long id);

    Optional<Shipment> findOne(Long id);

    Shipment update(Long shipmentId, ShipmentForUpdateDTO shipmentForUpdateDTO);

    Shipment create(Shipment shipment);
}
