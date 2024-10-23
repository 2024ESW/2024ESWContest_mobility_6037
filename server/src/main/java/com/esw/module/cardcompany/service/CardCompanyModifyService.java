package com.esw.module.cardcompany.service;

import com.esw.module.cardcompany.entities.CardCompany;
import com.esw.module.cardcompany.entities.CardCompanyModifyRequestDTO;
import com.esw.module.cardcompany.repository.CardCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CardCompanyModifyService {

    private CardCompanyRepository cardCompanyRepository;

    @Autowired
    public CardCompanyModifyService(CardCompanyRepository cardCompanyRepository) {
        this.cardCompanyRepository = cardCompanyRepository;
    }

    @Transactional
    public void modifyCardCompanyById(Long id, CardCompanyModifyRequestDTO cardCompanyInfo){

        Optional<CardCompany> optionalCardCompany = cardCompanyRepository.findById(id);

        // 엔티티가 존재하는지 확인
        if (optionalCardCompany.isPresent()) {
            CardCompany cardCompany = optionalCardCompany.get();

            // 받은 DTO에 따라 수정할 필드들을 업데이트
            if (cardCompanyInfo.getName() != null) {
                cardCompany.setName(cardCompanyInfo.getName());
            }

            // 자동으로 변경된 내용이 영속성 컨텍스트에 반영됨 (Transactional 덕분)
        } else {
            throw new IllegalArgumentException("ID에 해당하는 회사가 존재하지 않습니다.");
        }
    }
}
