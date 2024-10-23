package com.esw.module.paymentdetail.service;

import com.esw.module.member.entities.Member;
import com.esw.module.payment.entities.Payment;
import com.esw.module.payment.entities.PaymentModifyRequestDTO;
import com.esw.module.paymentdetail.entities.PaymentDetail;
import com.esw.module.paymentdetail.entities.PaymentDetailModifyRequestDTO;
import com.esw.module.paymentdetail.repository.PaymentDetailRepository;
import com.esw.module.product.entities.Product;
import com.esw.module.product.repository.ProductRepository;
import com.esw.module.vehicle.entities.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentDetailModifyService {

    private PaymentDetailRepository paymentDetailRepository;
    private ProductRepository productRepository;

    @Autowired
    public PaymentDetailModifyService(
            PaymentDetailRepository paymentDetailRepository,
            ProductRepository productRepository
            ){
        this.paymentDetailRepository = paymentDetailRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public void modifyPaymentDetailById(Long id, PaymentDetailModifyRequestDTO paymentDetailInfo) {
        Optional<PaymentDetail> optionalPaymentDetail = paymentDetailRepository.findById(id);

        if (optionalPaymentDetail.isPresent()) {
            PaymentDetail paymentDetail = optionalPaymentDetail.get();

            if (paymentDetailInfo.getProductId() != null) {
                Product product = productRepository.findById(paymentDetailInfo.getProductId())
                        .orElseThrow(() -> new IllegalArgumentException("Member ID가 존재하지 않습니다."));

                paymentDetail.setProduct(product);
            }
            if (paymentDetailInfo.getAmount() != null) {
                paymentDetail.setAmount(paymentDetailInfo.getAmount());
            }

        } else {
            throw new IllegalArgumentException("ID에 해당하는 결제 내역 상세가 존재하지 않습니다.");
        }
    }
}
