package com.esw.module.storescore.entities;

import com.esw.module.member.entities.Member;
import com.esw.module.store.entities.Store;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class StoreScoreFindResponseDTO {

    private Long id;
    private Long storeId;
    private Long memberId;
    private Integer score;
    private String detail;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public StoreScoreFindResponseDTO(StoreScore storeScore) {
        this.id = storeScore.getId();
        this.storeId = storeScore.getStore().getId();
        this.memberId = storeScore.getMember().getId();
        this.score = storeScore.getScore();
        this.detail = storeScore.getDetail();
        this.createdDate = storeScore.getCreatedDate();
        this.modifiedDate = storeScore.getModifiedDate();
    }
}
