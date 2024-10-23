package com.esw.module.paymentdetail.entities;

import com.esw.global.database.utils.EntityTimestamp;
import com.esw.module.product.entities.Product;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="TB_PAYMENT_DETAIL")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PaymentDetail extends EntityTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    private Integer amount;

    public PaymentDetail(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }
}
