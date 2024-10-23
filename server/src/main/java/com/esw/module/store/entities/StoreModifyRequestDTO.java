package com.esw.module.store.entities;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class StoreModifyRequestDTO {

    private Long id;
    private String name;
    private String latitude;
    private String longitude;
    private String location;
    private String storeCategory;

}
