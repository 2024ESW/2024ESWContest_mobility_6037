package com.esw.module.vehicle.entities;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class VehicleFindResponseDTO {

    private Long id;
    private String vehicleNo;
    private String model;
    private String color;
    private Boolean supportInternet;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public VehicleFindResponseDTO(Vehicle vehicleInfo) {
        this.id = vehicleInfo.getId();
        this.vehicleNo = vehicleInfo.getVehicleNo();
        this.model = vehicleInfo.getModel();
        this.color = vehicleInfo.getColor();
        this.supportInternet = vehicleInfo.getSupportInternet();
        this.createdDate = vehicleInfo.getCreatedDate();
        this.modifiedDate = vehicleInfo.getModifiedDate();
    }
}
