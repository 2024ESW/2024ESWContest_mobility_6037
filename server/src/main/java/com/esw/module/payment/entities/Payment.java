package com.esw.module.payment.entities;

import com.esw.global.database.utils.EntityTimestamp;
import com.esw.module.member.entities.Member;
import com.esw.module.vehicle.entities.Vehicle;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="TB_PAYMENT")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Payment extends EntityTimestamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;

    public Payment(Member member, Vehicle vehicle) {
        this.member = member;
        this.vehicle = vehicle;
    }
}
