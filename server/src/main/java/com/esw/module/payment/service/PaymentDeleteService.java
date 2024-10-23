package com.esw.module.payment.service;

import com.esw.module.member.repositories.MemberRepository;
import com.esw.module.payment.repository.PaymentRepository;
import com.esw.module.vehicle.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDeleteService {

    private PaymentRepository paymentRepository;
    private MemberRepository memberRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public PaymentDeleteService(
            PaymentRepository paymentRepository,
            MemberRepository memberRepository,
            VehicleRepository vehicleRepository
    ){
        this.paymentRepository = paymentRepository;
        this.memberRepository = memberRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public void deletePaymentById(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);  // ID에 해당하는 엔티티 삭제
        } else {
            throw new IllegalArgumentException("ID에 해당하는 결제 내역이 존재하지 않습니다.");
        }
    }
}
