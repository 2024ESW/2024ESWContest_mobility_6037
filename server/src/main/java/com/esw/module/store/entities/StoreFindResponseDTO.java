package com.esw.module.store.entities;

import com.esw.module.vehicle.entities.Vehicle;
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
public class StoreFindResponseDTO {

    private Long id;
    private String name;
    private String latitude;
    private String longitude;
    private String location;
    private String storeCategory;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public StoreFindResponseDTO(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.latitude = store.getLatitude();
        this.longitude = store.getLongitude();
        this.location = store.getLocation();
        this.storeCategory = store.getStoreCategory();
        this.createdDate = store.getCreatedDate();
        this.modifiedDate = store.getModifiedDate();
    }
}
