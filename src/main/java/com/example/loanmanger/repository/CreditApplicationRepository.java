package com.example.loanmanger.repository;

import com.example.loanmanger.domain.entity.CreditApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> {

    Page<CreditApplication> findByAcceptedIsTrue(Pageable pageable);
}
