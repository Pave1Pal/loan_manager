package com.example.loanmanger.service;

import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.domain.entity.CreditContract;

public interface CreditManager {

    CreditContract getContract(CreditApplication application);
}
