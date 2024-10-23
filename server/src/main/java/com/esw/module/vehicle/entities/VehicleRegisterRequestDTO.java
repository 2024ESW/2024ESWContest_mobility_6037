package com.esw.module.vehicle.entities;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class VehicleRegisterRequestDTO {

    private Long id;
    private String vehicleNo;
    private String model;
    private String color;
    private Boolean supportInternet;

}
