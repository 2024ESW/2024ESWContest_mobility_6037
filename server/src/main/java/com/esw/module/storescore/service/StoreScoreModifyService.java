package com.esw.module.storescore.service;

import com.esw.module.member.entities.Member;
import com.esw.module.member.repositories.MemberRepository;
import com.esw.module.store.entities.Store;
import com.esw.module.store.entities.StoreModifyRequestDTO;
import com.esw.module.store.repository.StoreRepository;
import com.esw.module.storescore.entities.StoreScore;
import com.esw.module.storescore.entities.StoreScoreModifyRequestDTO;
import com.esw.module.storescore.repository.StoreScoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreScoreModifyService {

    private StoreScoreRepository storeScoreRepository;
    private StoreRepository storeRepository;
    private MemberRepository memberRepository;

    @Autowired
    public StoreScoreModifyService (
            StoreScoreRepository storeScoreRepository,
            StoreRepository storeRepository,
            MemberRepository memberRepository
    ){
        this.storeScoreRepository = storeScoreRepository;
        this.storeRepository = storeRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void modifyStoreScoreById(Long id, StoreScoreModifyRequestDTO storeScoreInfo) {

        Optional<StoreScore> optionalStoreScore = storeScoreRepository.findById(id);

        // 엔티티가 존재하는지 확인
        if (optionalStoreScore.isPresent()) {
            StoreScore storeScore = optionalStoreScore.get();

            // 받은 DTO에 따라 수정할 필드들을 업데이트
            if (storeScoreInfo.getStoreId() != null) {
                Store store = storeRepository.findById(storeScoreInfo.getStoreId())
                        .orElseThrow(() -> new IllegalArgumentException("Store ID가 존재하지 않습니다."));

                storeScore.setStore(store);
            }

            if (storeScoreInfo.getMemberId() != null) {
                Member member = memberRepository.findById(storeScoreInfo.getMemberId())
                        .orElseThrow(() -> new IllegalArgumentException("Member ID가 존재하지 않습니다."));

                storeScore.setMember(member);
            }

            if (storeScoreInfo.getScore() != null) {
                storeScore.setScore(storeScoreInfo.getScore());
            }
            if (storeScoreInfo.getDetail() != null) {
                storeScore.setDetail(storeScoreInfo.getDetail());
            }

        } else {
            throw new IllegalArgumentException("ID에 해당하는 평가 기록이 존재하지 않습니다.");
        }

    }
}
