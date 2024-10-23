package com.esw.module.cardcompany.service;

import com.esw.module.cardcompany.entities.CardCompany;
import com.esw.module.cardcompany.entities.CardCompanyFindResponseDTO;
import com.esw.module.cardcompany.repository.CardCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardCompanyFindService {

    private CardCompanyRepository cardCompanyRepository;

    @Autowired
    public CardCompanyFindService(CardCompanyRepository cardCompanyRepository){
        this.cardCompanyRepository = cardCompanyRepository;
    }

    public List<CardCompanyFindResponseDTO> findAllCardCompanies() {

        List<CardCompanyFindResponseDTO> cardCompanyList = cardCompanyRepository.findAll().stream()
                .map(CardCompanyFindResponseDTO::new)
                .toList();

        cardCompanyList.forEach(System.out::println);

        return cardCompanyRepository.findAll()
                .stream()
                .map(CardCompanyFindResponseDTO::new)
                .toList();
    }

    public CardCompanyFindResponseDTO findCardCompanyById(Long id) {

        return new CardCompanyFindResponseDTO(cardCompanyRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }
}
