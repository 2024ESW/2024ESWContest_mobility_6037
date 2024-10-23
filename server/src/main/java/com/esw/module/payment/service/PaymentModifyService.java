package com.esw.module.payment.service;

import com.esw.module.member.entities.Member;
import com.esw.module.member.repositories.MemberRepository;
import com.esw.module.payment.entities.Payment;
import com.esw.module.payment.entities.PaymentModifyRequestDTO;
import com.esw.module.payment.repository.PaymentRepository;
import com.esw.module.product.entities.Product;
import com.esw.module.store.entities.Store;
import com.esw.module.vehicle.entities.Vehicle;
import com.esw.module.vehicle.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentModifyService {

    private PaymentRepository paymentRepository;
    private MemberRepository memberRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public PaymentModifyService(
            PaymentRepository paymentRepository,
            MemberRepository memberRepository,
            VehicleRepository vehicleRepository
    ){
        this.paymentRepository = paymentRepository;
        this.memberRepository = memberRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public void modifyPaymentById(Long id, PaymentModifyRequestDTO paymentInfo) {
        Optional<Payment> optionalPayment = paymentRepository.findById(id);

        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();

            // 받은 DTO에 따라 수정할 필드들을 업데이트
            if (paymentInfo.getMemberId() != null) {
                Member member = memberRepository.findById(paymentInfo.getMemberId())
                        .orElseThrow(() -> new IllegalArgumentException("Member ID가 존재하지 않습니다."));

                payment.setMember(member);
            }
            if (paymentInfo.getVehicleId() != null) {
                Vehicle vehicle = vehicleRepository.findById(paymentInfo.getVehicleId())
                        .orElseThrow(() -> new IllegalArgumentException("Vehicle ID가 존재하지 않습니다."));

                payment.setVehicle(vehicle);
            }

        } else {
            throw new IllegalArgumentException("ID에 해당하는 결제 내역이 존재하지 않습니다.");
        }
    }
}
