package com.esw.module.vehicle.service;

import com.esw.module.store.repository.StoreRepository;
import com.esw.module.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VehicleDeleteService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleDeleteService (VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public void deleteVehicleById(Long id) {

        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);  // ID에 해당하는 엔티티 삭제
        } else {
            throw new IllegalArgumentException("ID에 해당하는 차량이 존재하지 않습니다.");
        }

    }
}
