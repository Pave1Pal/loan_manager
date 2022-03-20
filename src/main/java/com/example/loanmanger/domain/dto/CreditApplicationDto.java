package com.example.loanmanger.domain.dto;

import com.example.loanmanger.domain.entity.CreditContract;
import com.example.loanmanger.domain.entity.Customer;
import com.example.loanmanger.domain.entity.embadable.Money;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.CascadeType.*;

public class CreditApplicationDto {

    private Long id;

    private Money desiredSum;

    private Money acceptedSum;

    private boolean accepted;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate creationDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate expirationDate;

    private Integer days;

    private Customer customer;

    private CreditContract creditContract;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Money getDesiredSum() {
        return desiredSum;
    }

    public void setDesiredSum(Money desiredSum) {
        this.desiredSum = desiredSum;
    }

    public Money getAcceptedSum() {
        return acceptedSum;
    }

    public void setAcceptedSum(Money acceptedSum) {
        this.acceptedSum = acceptedSum;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CreditContract getCreditContract() {
        return creditContract;
    }

    public void setCreditContract(CreditContract creditContract) {
        this.creditContract = creditContract;
    }
}
