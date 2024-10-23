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
public class PaymentFindResponseDTO {

    private Long id;
    private Long memberId;
    private Long vehicleId;


    public PaymentFindResponseDTO(Payment payment) {
        this.id = payment.getId();
        this.memberId = payment.getMember().getId();
        this.vehicleId = payment.getVehicle().getId();
    }
}
