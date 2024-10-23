package com.esw.module.vehicle.entities;

import com.esw.global.database.utils.EntityTimestamp;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="TB_VEHICLE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Vehicle extends EntityTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleNo;
    private String model;
    private String color;
    private Boolean supportInternet;

    public Vehicle(String vehicleNo, String model, String color, Boolean supportInternet) {
        this.vehicleNo = vehicleNo;
        this.model = model;
        this.color = color;
        this.supportInternet = supportInternet;
    }
}
