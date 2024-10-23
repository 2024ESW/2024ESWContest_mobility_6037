package com.esw.module.cardcompany.entities;

import com.esw.global.database.utils.EntityTimestamp;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class CardCompanyFindResponseDTO{

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String name;

    public CardCompanyFindResponseDTO(CardCompany cardCompany) {
        this.id = cardCompany.getId();
        this.createdDate = cardCompany.getCreatedDate();
        this.modifiedDate = cardCompany.getModifiedDate();
        this.name = cardCompany.getName();
    }
}
