package com.esw.module.paymentdetail.service;

import com.esw.module.payment.entities.PaymentFindResponseDTO;
import com.esw.module.paymentdetail.entities.PaymentDetailFindResponseDTO;
import com.esw.module.paymentdetail.repository.PaymentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentDetailFindService {

    private PaymentDetailRepository paymentDetailRepository;

    @Autowired
    public PaymentDetailFindService(PaymentDetailRepository paymentDetailRepository){
        this.paymentDetailRepository = paymentDetailRepository;
    }

    public List<PaymentDetailFindResponseDTO> findAllPaymentDetails() {
        List<PaymentDetailFindResponseDTO> paymentDetailList = paymentDetailRepository.findAll().stream()
                .map(PaymentDetailFindResponseDTO::new)
                .toList();

        paymentDetailList.forEach(System.out::println);

        return paymentDetailRepository.findAll()
                .stream()
                .map(PaymentDetailFindResponseDTO::new)
                .toList();

    }

    public PaymentDetailFindResponseDTO findPaymentDetailById(Long id) {

        return new PaymentDetailFindResponseDTO(paymentDetailRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }
}
