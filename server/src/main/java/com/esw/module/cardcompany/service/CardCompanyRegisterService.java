package com.esw.module.cardcompany.service;

import com.esw.module.cardcompany.entities.CardCompany;
import com.esw.module.cardcompany.entities.CardCompanyRegisterRequestDTO;
import com.esw.module.cardcompany.repository.CardCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CardCompanyRegisterService {

    private CardCompanyRepository cardCompanyRepository;

    @Autowired
    public CardCompanyRegisterService(
            CardCompanyRepository cardCompanyRepository
    ){
        this.cardCompanyRepository = cardCompanyRepository;
    }

    @Transactional
    public CardCompany registerCardCompany(CardCompanyRegisterRequestDTO cardCompanyInfo) {

        CardCompany newCardCompany = new CardCompany(
                cardCompanyInfo.getName()
        );

        CardCompany cardCompany = cardCompanyRepository.save(newCardCompany);

        // 엄격하게 하려면 반환 타입을 따로 지정해서 반환
        return cardCompany;
    }
}
