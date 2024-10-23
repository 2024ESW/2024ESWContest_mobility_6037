package com.esw.module.pgcompany.entities;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class PgCompanyRegisterRequestDTO {

    private Long id;
    private String name;

    public PgCompanyRegisterRequestDTO(String name){
        this.name = name;
    }

}
