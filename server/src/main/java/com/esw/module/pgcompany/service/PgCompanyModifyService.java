package com.esw.module.pgcompany.service;

import com.esw.module.cardcompany.entities.CardCompany;
import com.esw.module.cardcompany.entities.CardCompanyModifyRequestDTO;
import com.esw.module.cardcompany.repository.CardCompanyRepository;
import com.esw.module.pgcompany.entities.PgCompany;
import com.esw.module.pgcompany.entities.PgCompanyModifyRequestDTO;
import com.esw.module.pgcompany.repository.PgCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PgCompanyModifyService {

    private PgCompanyRepository pgCompanyRepository;

    @Autowired
    public PgCompanyModifyService(PgCompanyRepository pgCompanyRepository) {
        this.pgCompanyRepository = pgCompanyRepository;
    }

    @Transactional
    public void modifyPgCompanyById(Long id, PgCompanyModifyRequestDTO pgCompanyInfo){

        Optional<PgCompany> optionalPgCompany = pgCompanyRepository.findById(id);

        // 엔티티가 존재하는지 확인
        if (optionalPgCompany.isPresent()) {
            PgCompany pgCompany = optionalPgCompany.get();

            // 받은 DTO에 따라 수정할 필드들을 업데이트
            if (pgCompanyInfo.getName() != null) {
                pgCompany.setName(pgCompanyInfo.getName());
            }

            // 자동으로 변경된 내용이 영속성 컨텍스트에 반영됨 (Transactional 덕분)
        } else {
            throw new IllegalArgumentException("ID에 해당하는 PG사가 존재하지 않습니다.");
        }
    }
}
