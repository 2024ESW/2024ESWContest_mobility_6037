package com.esw.module.cardcompany.service;

import com.esw.module.cardcompany.repository.CardCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardCompanyDeleteService {

    private CardCompanyRepository cardCompanyRepository;

    @Autowired
    public CardCompanyDeleteService (CardCompanyRepository cardCompanyRepository){
        this.cardCompanyRepository = cardCompanyRepository;
    }

    @Transactional
    public void deleteCardCompanyById(Long id){

        if (cardCompanyRepository.existsById(id)) {
            cardCompanyRepository.deleteById(id);  // ID에 해당하는 엔티티 삭제
        } else {
            throw new IllegalArgumentException("ID에 해당하는 회사가 존재하지 않습니다.");
        }

    }
}
