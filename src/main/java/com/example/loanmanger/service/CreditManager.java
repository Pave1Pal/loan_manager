package com.example.loanmanger.service;

import com.example.loanmanger.domain.entity.CreditApplication;
import org.springframework.stereotype.Service;

@Service
public interface CreditManager {

    boolean makeDecision(CreditApplication application);
}
