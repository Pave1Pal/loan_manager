package com.example.loanmanger.service;

import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.domain.entity.CreditContract;
import org.springframework.stereotype.Service;

public interface CreditManager {

    CreditContract getContract(CreditApplication application);
}
