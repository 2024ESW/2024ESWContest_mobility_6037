package com.esw.module.vehicle.service;

import com.esw.module.store.entities.Store;
import com.esw.module.vehicle.entities.Vehicle;
import com.esw.module.vehicle.entities.VehicleModifyRequestDTO;
import com.esw.module.vehicle.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleModifyService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleModifyService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public void modifyVehicleById(Long id, VehicleModifyRequestDTO vehicleInfo) {

        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(id);

        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();

            if (vehicleInfo.getVehicleNo() != null) {
                vehicle.setVehicleNo(vehicleInfo.getVehicleNo());
            }
            if (vehicleInfo.getModel() != null) {
                vehicle.setModel(vehicleInfo.getModel());
            }
            if (vehicleInfo.getColor() != null) {
                vehicle.setColor(vehicleInfo.getColor());
            }
            if (vehicleInfo.getSupportInternet() != null) {
                vehicle.setSupportInternet(vehicleInfo.getSupportInternet());
            }

        } else {
            throw new IllegalArgumentException("ID에 해당하는 차량이 존재하지 않습니다.");
        }

    }
}
