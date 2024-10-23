package com.esw.module.store.service;

import com.esw.module.pgcompany.repository.PgCompanyRepository;
import com.esw.module.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreDeleteService {

    private StoreRepository storeRepository;

    @Autowired
    public StoreDeleteService (StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    @Transactional
    public void deleteStoreById(Long id){

        if (storeRepository.existsById(id)) {
            storeRepository.deleteById(id);  // ID에 해당하는 엔티티 삭제
        } else {
            throw new IllegalArgumentException("ID에 해당하는 매장이 존재하지 않습니다.");
        }

    }
}
