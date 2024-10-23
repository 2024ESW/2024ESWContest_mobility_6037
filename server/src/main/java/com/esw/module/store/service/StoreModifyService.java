package com.esw.module.store.service;

import com.esw.module.pgcompany.entities.PgCompany;
import com.esw.module.store.entities.Store;
import com.esw.module.store.entities.StoreModifyRequestDTO;
import com.esw.module.store.repository.StoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreModifyService {

    private StoreRepository storeRepository;

    @Autowired
    public StoreModifyService (StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    @Transactional
    public void modifyStoreById(Long id, StoreModifyRequestDTO storeInfo) {

        Optional<Store> optionalStore = storeRepository.findById(id);

        System.out.println(123);
        // 엔티티가 존재하는지 확인
        if (optionalStore.isPresent()) {
            Store store = optionalStore.get();

            System.out.println(456);

            // 받은 DTO에 따라 수정할 필드들을 업데이트
            if (storeInfo.getName() != null) {
                store.setName(storeInfo.getName());
            }

            if (storeInfo.getLatitude() != null) {
                store.setLatitude(storeInfo.getLatitude());
            }

            if (storeInfo.getLongitude() != null) {
                store.setLongitude(storeInfo.getLongitude());
            }
            if (storeInfo.getLocation() != null) {
                store.setLocation(storeInfo.getLocation());
            }
            if (storeInfo.getStoreCategory() != null) {
                store.setStoreCategory(storeInfo.getStoreCategory());
            }

            // 자동으로 변경된 내용이 영속성 컨텍스트에 반영됨 (Transactional 덕분)
        } else {
            throw new IllegalArgumentException("ID에 해당하는 가맹점이 존재하지 않습니다.");
        }

    }
}
