package com.esw.module.paymentdetail.repository;

import com.esw.module.paymentdetail.entities.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Long> {
}
