package com.example.loanmanger.service;

import com.example.loanmanger.domain.entity.CreditApplication;
import org.springframework.stereotype.Service;

public interface CreditManager {

    CreditApplication makeDecision(CreditApplication application);
}
