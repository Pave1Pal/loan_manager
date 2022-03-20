package com.example.loanmanger.service;

import com.example.loanmanger.domain.entity.CreditApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface CreditApplicationService {

    CreditApplication create(CreditApplication application);

    Page<CreditApplication> getAcceptedIsTrue(Pageable pageable);
}
