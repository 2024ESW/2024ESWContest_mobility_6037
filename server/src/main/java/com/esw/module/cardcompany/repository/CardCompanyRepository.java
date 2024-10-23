package com.esw.module.cardcompany.repository;

import com.esw.module.cardcompany.entities.CardCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardCompanyRepository extends JpaRepository<CardCompany, Long> {
}
