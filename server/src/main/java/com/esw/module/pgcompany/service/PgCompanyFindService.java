package com.esw.module.pgcompany.service;

import com.esw.module.cardcompany.entities.CardCompanyFindResponseDTO;
import com.esw.module.cardcompany.repository.CardCompanyRepository;
import com.esw.module.pgcompany.entities.PgCompanyFindResponseDTO;
import com.esw.module.pgcompany.repository.PgCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PgCompanyFindService {
    private PgCompanyRepository pgCompanyRepository;

    @Autowired
    public PgCompanyFindService(PgCompanyRepository pgCompanyRepository){
        this.pgCompanyRepository = pgCompanyRepository;
    }

    public List<PgCompanyFindResponseDTO> findAllPgCompanies() {

        List<PgCompanyFindResponseDTO> pgCompanyList = pgCompanyRepository.findAll().stream()
                .map(PgCompanyFindResponseDTO::new)
                .toList();

        pgCompanyList.forEach(System.out::println);

        return pgCompanyRepository.findAll()
                .stream()
                .map(PgCompanyFindResponseDTO::new)
                .toList();
    }

    public PgCompanyFindResponseDTO findPgCompanyById(Long id) {

        return new PgCompanyFindResponseDTO(pgCompanyRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }
}
