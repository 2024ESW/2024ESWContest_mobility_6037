package com.esw.module.product.entities;


import com.esw.global.database.utils.EntityTimestamp;
import com.esw.module.store.entities.Store;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="TB_PRODUCT")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Product extends EntityTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="STORE_ID")
    private Store store;

    private String name;
    private Integer price;
    private String productCategory;

    public Product(Store store, String name, Integer price, String productCategory) {
        this.store = store;
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }
}
