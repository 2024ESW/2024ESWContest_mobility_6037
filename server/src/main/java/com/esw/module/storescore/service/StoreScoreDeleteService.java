package com.esw.module.storescore.service;

import com.esw.module.store.repository.StoreRepository;
import com.esw.module.storescore.repository.StoreScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreScoreDeleteService {
    private StoreScoreRepository storeScoreRepository;

    @Autowired
    public StoreScoreDeleteService (StoreScoreRepository storeScoreRepository){
        this.storeScoreRepository = storeScoreRepository;
    }

    @Transactional
    public void deleteStoreScoreById(Long id){

        if (storeScoreRepository.existsById(id)) {
            storeScoreRepository.deleteById(id);  // ID에 해당하는 엔티티 삭제
        } else {
            throw new IllegalArgumentException("ID에 해당하는 평가 내역이 존재하지 않습니다.");
        }

    }

}
