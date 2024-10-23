package com.esw.module.payment.entities;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class PaymentModifyRequestDTO {

    private Long id;
    private Long memberId;
    private Long vehicleId;

}
