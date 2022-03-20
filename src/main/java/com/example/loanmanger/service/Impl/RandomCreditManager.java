package com.example.loanmanger.service.Impl;

import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.domain.entity.embadable.Money;
import com.example.loanmanger.service.CreditApplicationService;
import com.example.loanmanger.service.CreditManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class RandomCreditManager implements CreditManager {

    @Autowired
    public RandomCreditManager(CreditApplicationService creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
    }

    private final CreditApplicationService creditApplicationService;

    @Override
    @Transactional
    public CreditApplication makeDecision(CreditApplication application) {
        return isApplicationAccepted() ? acceptAndSave(application) : deniedAndSave(application);
    }

    private boolean isApplicationAccepted() {
        return Math.random() < 0.5;
    }

    private CreditApplication deniedAndSave(CreditApplication application) {
        application.setAccepted(false);
        return creditApplicationService.create(application);
    }

    private CreditApplication acceptAndSave(CreditApplication application) {
        application.setAccepted(true);
        setDaysOfCreditAndExpirationDate(application);
        setAcceptedSum(application);
        return creditApplicationService.create(application);
    }

    private void setDaysOfCreditAndExpirationDate(CreditApplication application) {
        int daysOfMonth = 30;
        int monthInYear = 12;
        int days = (1 + (int)(Math.random() * monthInYear)) * daysOfMonth;
        LocalDate expirationDate = application.getCreationDate().plusDays(days);
        application.setDays(days);
        application.setExpirationDate(expirationDate);
    }

    private void setAcceptedSum(CreditApplication application) {
        Money desiredSum = application.getDesiredSum();
        Money acceptedSum;
        do {
            acceptedSum = calculateAcceptedSumBy(desiredSum);
        } while (acceptedSum.getIntegerPart() == 0);
        application.setAcceptedSum(acceptedSum);
    }

    private Money calculateAcceptedSumBy(Money desiredSum) {
        Money acceptedSum = new Money();
        acceptedSum.setDecimalPart(desiredSum.getDecimalPart());
        acceptedSum.setIntegerPart((long) (desiredSum.getIntegerPart() * Math.random()));
        return acceptedSum;
    }
}
