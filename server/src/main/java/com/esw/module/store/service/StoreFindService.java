package com.esw.module.store.service;

import com.esw.module.pgcompany.entities.PgCompanyFindResponseDTO;
import com.esw.module.pgcompany.repository.PgCompanyRepository;
import com.esw.module.store.entities.StoreFindResponseDTO;
import com.esw.module.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreFindService {

    private StoreRepository storeRepository;

    @Autowired
    public StoreFindService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    public List<StoreFindResponseDTO> findAllStores() {

        List<StoreFindResponseDTO> storeList = storeRepository.findAll().stream()
                .map(StoreFindResponseDTO::new)
                .toList();

        storeList.forEach(System.out::println);

        return storeRepository.findAll()
                .stream()
                .map(StoreFindResponseDTO::new)
                .toList();
    }

    public StoreFindResponseDTO findStoreById(Long id) {

        return new StoreFindResponseDTO(storeRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }
}
