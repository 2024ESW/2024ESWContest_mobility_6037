package com.esw.module.storescore.service;

import com.esw.module.store.entities.StoreFindResponseDTO;
import com.esw.module.storescore.entities.StoreScoreFindResponseDTO;
import com.esw.module.storescore.repository.StoreScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreScoreFindService {

    private StoreScoreRepository storeScoreRepository;

    @Autowired
    public StoreScoreFindService(StoreScoreRepository storeScoreRepository) {
        this.storeScoreRepository = storeScoreRepository;
    }

    public List<StoreScoreFindResponseDTO> findAllStoreScores() {
        List<StoreScoreFindResponseDTO> storeScoreList = storeScoreRepository.findAll().stream()
                .map(StoreScoreFindResponseDTO::new)
                .toList();

        storeScoreList.forEach(System.out::println);

        return storeScoreRepository.findAll()
                .stream()
                .map(StoreScoreFindResponseDTO::new)
                .toList();
    }

    public StoreScoreFindResponseDTO findStoreById(Long id) {

        return new StoreScoreFindResponseDTO(storeScoreRepository.findById(id).orElseThrow(IllegalArgumentException::new));

    }
}
