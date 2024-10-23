package com.esw.module.paymentdetail.entities;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PaymentDetailFindResponseDTO {

    private Long id;
    private Long productId;
    private Integer amount;

    public PaymentDetailFindResponseDTO(PaymentDetail paymentDetail) {
        this.id = paymentDetail.getId();
        this.productId = paymentDetail.getProduct().getId();
        this.amount = paymentDetail.getAmount();
    }
}
