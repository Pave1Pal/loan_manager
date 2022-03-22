package com.example.loanmanger.domain.dto;

import com.example.loanmanger.domain.entity.Customer;
import com.example.loanmanger.domain.entity.embadable.Money;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateApplicationDto {

    @Valid
    @NotNull
    private Money desiredSum;

    @Valid
    @NotNull
    private Customer customer;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate creationDate = LocalDate.now();

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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
