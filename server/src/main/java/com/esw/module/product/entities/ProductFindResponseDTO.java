package com.esw.module.product.entities;

import com.esw.module.store.entities.Store;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProductFindResponseDTO {

    private Long id;
    private Long storeId;
    private String name;
    private Integer price;
    private String productCategory;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public ProductFindResponseDTO(Product product) {

        this.id = product.getId();
        this.storeId = product.getStore().getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.productCategory = product.getProductCategory();
        this.createdDate = product.getCreatedDate();
        this.modifiedDate = product.getModifiedDate();

    }
}
