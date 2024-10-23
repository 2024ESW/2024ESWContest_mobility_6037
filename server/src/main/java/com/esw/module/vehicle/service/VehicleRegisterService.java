package com.esw.module.vehicle.service;

import com.esw.module.store.entities.Store;
import com.esw.module.vehicle.entities.Vehicle;
import com.esw.module.vehicle.entities.VehicleRegisterRequestDTO;
import com.esw.module.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleRegisterService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleRegisterService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    public Vehicle registerVehicle(VehicleRegisterRequestDTO vehicleInfo) {

        Vehicle newVehicle = new Vehicle(
                vehicleInfo.getVehicleNo(),
                vehicleInfo.getModel(),
                vehicleInfo.getColor(),
                vehicleInfo.getSupportInternet()
        );

        Vehicle vehicle = vehicleRepository.save(newVehicle);

        // 엄격하게 하려면 반환 타입을 따로 지정해서 반환
        return vehicle;

    }
}
