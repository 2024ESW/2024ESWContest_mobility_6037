package com.esw.module.paymentdetail.service;

import com.esw.module.paymentdetail.repository.PaymentDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailDeleteService {

    private PaymentDetailRepository paymentDetailRepository;

    @Autowired
    public PaymentDetailDeleteService(PaymentDetailRepository paymentDetailRepository){
        this.paymentDetailRepository = paymentDetailRepository;
    }

    @Transactional
    public void deletePaymentDetailById(Long id) {
        if (paymentDetailRepository.existsById(id)) {
            paymentDetailRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("ID에 해당하는 결제 내역 상세가 존재하지 않습니다.");
        }
    }
}
