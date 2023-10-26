package com.octa.courierXpress.repository;

import com.octa.courierXpress.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
