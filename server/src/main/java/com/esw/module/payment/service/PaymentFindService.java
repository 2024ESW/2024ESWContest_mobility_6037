package com.esw.module.payment.service;

import com.esw.module.member.repositories.MemberRepository;
import com.esw.module.payment.entities.PaymentFindResponseDTO;
import com.esw.module.payment.repository.PaymentRepository;
import com.esw.module.product.entities.ProductFindResponseDTO;
import com.esw.module.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentFindService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentFindService(
            PaymentRepository paymentRepository
    ){
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentFindResponseDTO> findAllPayments() {
        List<PaymentFindResponseDTO> paymentList = paymentRepository.findAll().stream()
                .map(PaymentFindResponseDTO::new)
                .toList();

        paymentList.forEach(System.out::println);

        return paymentRepository.findAll()
                .stream()
                .map(PaymentFindResponseDTO::new)
                .toList();

    }

    public PaymentFindResponseDTO findPaymentById(Long id) {

        return new PaymentFindResponseDTO(paymentRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }
}
