package com.esw.module.payment.service;

import com.esw.module.member.entities.Member;
import com.esw.module.member.repositories.MemberRepository;
import com.esw.module.payment.entities.Payment;
import com.esw.module.payment.entities.PaymentRegisterRequestDTO;
import com.esw.module.payment.repository.PaymentRepository;
import com.esw.module.product.entities.Product;
import com.esw.module.store.entities.Store;
import com.esw.module.vehicle.entities.Vehicle;
import com.esw.module.vehicle.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentRegisterService {

    private PaymentRepository paymentRepository;
    private MemberRepository memberRepository;
    private VehicleRepository vehicleRepository;

    @Autowired
    public PaymentRegisterService(
            PaymentRepository paymentRepository,
            MemberRepository memberRepository,
            VehicleRepository vehicleRepository
    ){
        this.paymentRepository = paymentRepository;
        this.memberRepository = memberRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public Payment registerPayment(PaymentRegisterRequestDTO paymentInfo) {

        Member member = memberRepository.findById(paymentInfo.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member ID가 존재하지 않습니다."));

        Vehicle vehicle = vehicleRepository.findById(paymentInfo.getVehicleId())
                .orElseThrow(() -> new IllegalArgumentException("Vehicle ID가 존재하지 않습니다."));

        Payment newPayment = new Payment(
                member,
                vehicle
        );

        Payment payment = paymentRepository.save(newPayment);

        return payment;
    }
}
