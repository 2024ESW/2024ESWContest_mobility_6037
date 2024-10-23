package com.esw.module.paymentdetail.service;

import com.esw.module.member.entities.Member;
import com.esw.module.payment.entities.Payment;
import com.esw.module.payment.entities.PaymentRegisterRequestDTO;
import com.esw.module.paymentdetail.entities.PaymentDetail;
import com.esw.module.paymentdetail.entities.PaymentDetailRegisterRequestDTO;
import com.esw.module.paymentdetail.repository.PaymentDetailRepository;
import com.esw.module.product.entities.Product;
import com.esw.module.product.repository.ProductRepository;
import com.esw.module.vehicle.entities.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailRegisterService {

    private PaymentDetailRepository paymentDetailRepository;
    private ProductRepository productRepository;

    @Autowired
    public PaymentDetailRegisterService(
            PaymentDetailRepository paymentDetailRepository,
            ProductRepository productRepository
            ){
        this.paymentDetailRepository = paymentDetailRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public PaymentDetail registerPaymentDetail(PaymentDetailRegisterRequestDTO paymentDetailInfo) {

        Product product = productRepository.findById(paymentDetailInfo.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Member ID가 존재하지 않습니다."));

        PaymentDetail newPaymentDetail = new PaymentDetail(
                product,
                paymentDetailInfo.getAmount()
        );

        PaymentDetail paymentDetail = paymentDetailRepository.save(newPaymentDetail);

        return paymentDetail;
    }
}
