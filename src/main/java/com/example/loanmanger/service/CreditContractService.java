package com.example.loanmanger.service;

import com.example.loanmanger.domain.entity.CreditContract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface CreditContractService {

    CreditContract create(CreditContract contract);

    Page<CreditContract> getAcceptedByUser(Pageable pageable);
}
