package com.esw.module.pgcompany.service;

import com.esw.module.cardcompany.repository.CardCompanyRepository;
import com.esw.module.pgcompany.repository.PgCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PgCompanyDeleteService {

    private PgCompanyRepository pgCompanyRepository;

    @Autowired
    public PgCompanyDeleteService (PgCompanyRepository pgCompanyRepository){
        this.pgCompanyRepository = pgCompanyRepository;
    }

    @Transactional
    public void deletePgCompanyById(Long id){

        if (pgCompanyRepository.existsById(id)) {
            pgCompanyRepository.deleteById(id);  // ID에 해당하는 엔티티 삭제
        } else {
            throw new IllegalArgumentException("ID에 해당하는 PG사가 존재하지 않습니다.");
        }

    }
}
