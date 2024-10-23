package com.esw.module.store.entities;

import com.esw.global.database.utils.EntityTimestamp;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="TB_STORE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Store extends EntityTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String latitude;
    private String longitude;
    private String location;
    private String storeCategory;

    public Store(
            String name,
            String latitude,
            String longitude,
            String location,
            String storeCategory)
    {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
        this.storeCategory = storeCategory;
    }
}
