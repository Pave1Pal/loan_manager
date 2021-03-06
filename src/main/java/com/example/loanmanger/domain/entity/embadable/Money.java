package com.example.loanmanger.domain.entity.embadable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.loanmanger.domain.entity.constants.Currency;

@Embeddable
public class Money {

    @NotNull
    @Column(name = "money_integer")
    private Long integerPart;

    @Column(name = "money_decimal")
    private int decimalPart;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "money_currency")
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Long getIntegerPart() {
        return integerPart;
    }

    public void setIntegerPart(Long integerPart) {
        this.integerPart = integerPart;
    }

    public int getDecimalPart() {
        return decimalPart;
    }

    public void setDecimalPart(int decimalPart) {
        this.decimalPart = decimalPart;
    }

    @Override
    public String toString() {
        return integerPart + "." + decimalPart + " " + currency.getDisplayName();
    }
}
