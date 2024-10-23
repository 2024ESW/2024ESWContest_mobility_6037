package com.esw.module.store.service;

import com.esw.module.pgcompany.entities.PgCompany;
import com.esw.module.pgcompany.entities.PgCompanyRegisterRequestDTO;
import com.esw.module.pgcompany.repository.PgCompanyRepository;
import com.esw.module.store.entities.Store;
import com.esw.module.store.entities.StoreRegisterRequestDTO;
import com.esw.module.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreRegisterService {

    private StoreRepository storeRepository;

    @Autowired
    public StoreRegisterService(
            StoreRepository storeRepository
    ){
        this.storeRepository = storeRepository;
    }

    @Transactional
    public Store registerStore(StoreRegisterRequestDTO storeInfo) {

        Store newStore = new Store(
                storeInfo.getName(),
                storeInfo.getLatitude(),
                storeInfo.getLongitude(),
                storeInfo.getLocation(),
                storeInfo.getStoreCategory()
        );

        Store store = storeRepository.save(newStore);

        // 엄격하게 하려면 반환 타입을 따로 지정해서 반환
        return store;
    }
}
