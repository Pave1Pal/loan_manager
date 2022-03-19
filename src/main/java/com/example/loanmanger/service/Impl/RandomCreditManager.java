package com.example.loanmanger.service.Impl;

import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.domain.entity.embadable.Money;
import com.example.loanmanger.service.CreditApplicationService;
import com.example.loanmanger.service.CreditManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RandomCreditManager implements CreditManager {

    @Autowired
    public RandomCreditManager(CreditApplicationService creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
    }

    private final CreditApplicationService creditApplicationService;

    @Override
    @Transactional
    public boolean makeDecision(CreditApplication application) {
        if (isNotApplicationAccepted()) {
            return deniedAndSave(application);
        }
        return acceptAndSave(application);
    }

    private boolean isNotApplicationAccepted() {
        return Math.random() < 0.5;
    }

    private boolean deniedAndSave(CreditApplication application) {
        application.setAccepted(false);
        creditApplicationService.create(application);
        return false;
    }

    private boolean acceptAndSave(CreditApplication application) {
        application.setAccepted(true);
        setDaysOfCredit(application);
        setAcceptedSum(application);
        creditApplicationService.create(application);
        return true;
    }

    private void setDaysOfCredit(CreditApplication application) {
        int daysOfMonth = 30;
        int monthInYear = 12;
        int days = (1 + (int)(Math.random() * monthInYear)) * daysOfMonth;
        application.setDays(days);
    }

    private void setAcceptedSum(CreditApplication application) {
        Money desiredSum = application.getDesiredSum();
        Money acceptedSum;
        do {
            acceptedSum = calculateAcceptedSumBy(desiredSum);
        } while (acceptedSum.getIntegerValue() == 0);
        application.setAcceptedSum(acceptedSum);
    }

    private Money calculateAcceptedSumBy(Money desiredSum) {
        Money acceptedSum = new Money();
        acceptedSum.setDecimalValue(desiredSum.getDecimalValue());
        acceptedSum.setIntegerValue((long) (desiredSum.getIntegerValue() * Math.random()));
        return acceptedSum;
    }
}
