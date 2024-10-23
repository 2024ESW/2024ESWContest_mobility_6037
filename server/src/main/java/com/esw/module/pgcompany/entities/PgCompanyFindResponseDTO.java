package com.esw.module.pgcompany.entities;

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
public class PgCompanyFindResponseDTO {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String name;

    public PgCompanyFindResponseDTO(PgCompany pgCompany) {
        this.id = pgCompany.getId();
        this.createdDate = pgCompany.getCreatedDate();
        this.modifiedDate = pgCompany.getModifiedDate();
        this.name = pgCompany.getName();
    }
}
