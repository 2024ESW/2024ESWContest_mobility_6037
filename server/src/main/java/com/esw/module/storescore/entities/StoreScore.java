package com.esw.module.storescore.entities;

import com.esw.global.database.utils.EntityTimestamp;
import com.esw.module.member.entities.Member;
import com.esw.module.store.entities.Store;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="TB_STORE_SCORE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class StoreScore extends EntityTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="STORE_ID")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    private Integer score;
    private String detail;

    public StoreScore(
            Store store,
            Member member,
            Integer score,
            String detail) {
//        this.store.setId(storeId);
//        this.member.setId(memberId);
        this.store = store;
        this.member = member;
        this.score = score;
        this.detail = detail;
    }
}
