package com.esw.module.paymentdetail.entities;

import com.esw.module.product.entities.Product;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PaymentDetailRegisterRequestDTO {

    private Long id;
    private Long productId;
    private Integer amount;

}
