package com.esw.module.vehicle.repository;

import com.esw.module.vehicle.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
