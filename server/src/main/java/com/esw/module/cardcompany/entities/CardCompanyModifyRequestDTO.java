package com.esw.module.cardcompany.entities;

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
public class CardCompanyModifyRequestDTO {

    private Long id;
    private String name;

    public CardCompanyModifyRequestDTO(String name){
        this.name = name;
    }

}
