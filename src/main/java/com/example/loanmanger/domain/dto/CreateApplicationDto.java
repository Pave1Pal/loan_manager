package com.example.loanmanger.domain.dto;

import com.example.loanmanger.domain.entity.Customer;
import com.example.loanmanger.domain.entity.embadable.Money;

public class CreateApplicationDto {

    private Money desiredSum;
    private Customer customer;

    public Money getDesiredSum() {
        return desiredSum;
    }

    public void setDesiredSum(Money desiredSum) {
        this.desiredSum = desiredSum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
