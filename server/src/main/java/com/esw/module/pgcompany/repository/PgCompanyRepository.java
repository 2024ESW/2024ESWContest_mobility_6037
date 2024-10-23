package com.esw.module.pgcompany.repository;

import com.esw.module.pgcompany.entities.PgCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PgCompanyRepository extends JpaRepository<PgCompany, Long> {
}
