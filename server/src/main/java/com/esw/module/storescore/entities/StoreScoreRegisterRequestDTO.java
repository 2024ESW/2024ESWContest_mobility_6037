package com.esw.module.storescore.entities;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class StoreScoreRegisterRequestDTO {

    private Long id;
    private Long storeId;
    private Long memberId;
    private Integer score;
    private String detail;
}
