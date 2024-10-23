package com.esw.module.store.entities;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class StoreRegisterRequestDTO {

    private String id;
    private String name;
    private String latitude;
    private String longitude;
    private String location;
    private String storeCategory;

    public StoreRegisterRequestDTO(Store store) {
        this.name = store.getName();
        this.latitude = store.getLatitude();
        this.longitude = store.getLongitude();
        this.location = store.getLocation();
        this.storeCategory = store.getStoreCategory();
    }
}
