package com.esw.module.product.entities;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProductModifyRequestDTO {

    private Long id;
    private Long storeId;
    private String name;
    private Integer price;
    private String productCategory;

}
