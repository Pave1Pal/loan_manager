package com.example.loanmanger.domain.entity.embadable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Currency;

@Embeddable
public class Money {

    private Long integerValue;

    private int decimalValue;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Long getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(Long integerValue) {
        this.integerValue = integerValue;
    }

    public int getDecimalValue() {
        return decimalValue;
    }

    public void setDecimalValue(int decimalValue) {
        this.decimalValue = decimalValue;
    }
}
