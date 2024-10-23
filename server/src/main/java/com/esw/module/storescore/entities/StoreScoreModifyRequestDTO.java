package com.esw.module.storescore.entities;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class StoreScoreModifyRequestDTO {

    private Long id;
    private Long storeId;
    private Long memberId;
    private Integer score;
    private String detail;

}
