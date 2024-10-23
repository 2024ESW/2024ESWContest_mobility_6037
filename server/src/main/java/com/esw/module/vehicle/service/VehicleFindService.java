package com.esw.module.vehicle.service;

import com.esw.module.store.entities.StoreFindResponseDTO;
import com.esw.module.vehicle.entities.VehicleFindResponseDTO;
import com.esw.module.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleFindService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleFindService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleFindResponseDTO> findAllVehicles() {
        List<VehicleFindResponseDTO> vehicleList = vehicleRepository.findAll().stream()
                .map(VehicleFindResponseDTO::new)
                .toList();

        vehicleList.forEach(System.out::println);

        return vehicleRepository.findAll()
                .stream()
                .map(VehicleFindResponseDTO::new)
                .toList();
    }

    public VehicleFindResponseDTO findVehicleById(Long id) {

        return new VehicleFindResponseDTO(vehicleRepository.findById(id).orElseThrow(IllegalArgumentException::new));

    }
}
