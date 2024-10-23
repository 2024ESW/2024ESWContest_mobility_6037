package com.esw.module.pgcompany.service;

import com.esw.module.cardcompany.entities.CardCompany;
import com.esw.module.cardcompany.entities.CardCompanyRegisterRequestDTO;
import com.esw.module.cardcompany.repository.CardCompanyRepository;
import com.esw.module.pgcompany.entities.PgCompany;
import com.esw.module.pgcompany.entities.PgCompanyRegisterRequestDTO;
import com.esw.module.pgcompany.repository.PgCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PgCompanyRegisterService {

    private PgCompanyRepository pgCompanyRepository;

    @Autowired
    public PgCompanyRegisterService(
            PgCompanyRepository pgCompanyRepository
    ){
        this.pgCompanyRepository = pgCompanyRepository;
    }

    @Transactional
    public PgCompany registerPgCompany(PgCompanyRegisterRequestDTO pgCompanyInfo) {

        PgCompany newPgCompany = new PgCompany(
                pgCompanyInfo.getName()
        );

        PgCompany pgCompany = pgCompanyRepository.save(newPgCompany);

        // 엄격하게 하려면 반환 타입을 따로 지정해서 반환
        return pgCompany;
    }
}
