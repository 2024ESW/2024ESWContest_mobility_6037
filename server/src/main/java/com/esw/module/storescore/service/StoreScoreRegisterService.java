package com.esw.module.storescore.service;

import com.esw.module.member.entities.Member;
import com.esw.module.member.repositories.MemberRepository;
import com.esw.module.store.entities.Store;
import com.esw.module.store.repository.StoreRepository;
import com.esw.module.storescore.entities.StoreScore;
import com.esw.module.storescore.entities.StoreScoreRegisterRequestDTO;
import com.esw.module.storescore.repository.StoreScoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreScoreRegisterService {

    private StoreScoreRepository storeScoreRepository;
    private StoreRepository storeRepository;
    private MemberRepository memberRepository;

    @Autowired
    public StoreScoreRegisterService(
            StoreScoreRepository storeScoreRepository,
            StoreRepository storeRepository,
            MemberRepository memberRepository
    ) {
        this.storeScoreRepository = storeScoreRepository;
        this.storeRepository = storeRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public StoreScore registerStoreScore(StoreScoreRegisterRequestDTO storeScoreInfo) {

        Store store = storeRepository.findById(storeScoreInfo.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store ID가 존재하지 않습니다."));

        Member member = memberRepository.findById(storeScoreInfo.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member ID가 존재하지 않습니다."));

        StoreScore newStoreScore = new StoreScore(
                store,
                member,
                storeScoreInfo.getScore(),
                storeScoreInfo.getDetail()
        );

        StoreScore storeScore = storeScoreRepository.save(newStoreScore);

        // 엄격하게 하려면 반환 타입을 따로 지정해서 반환
        return storeScore;
    }
}
