package com.example.loanmanger.repository;

import com.example.loanmanger.domain.entity.CreditContract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditContractRepository extends JpaRepository<CreditContract, Long> {
    
    Page<CreditContract> findByAcceptedByUserIsTrue(Pageable pageable);
}
