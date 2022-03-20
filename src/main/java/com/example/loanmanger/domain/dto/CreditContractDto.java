package com.example.loanmanger.domain.dto;

import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.domain.entity.Customer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreditContractDto {

    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate singInDate;

    private boolean acceptedByUser;

    private Customer customer;

    private CreditApplication creditApplication;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSingInDate() {
        return singInDate;
    }

    public void setSingInDate(LocalDate singInDate) {
        this.singInDate = singInDate;
    }

    public boolean isAcceptedByUser() {
        return acceptedByUser;
    }

    public void setAcceptedByUser(boolean acceptedByUser) {
        this.acceptedByUser = acceptedByUser;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CreditApplication getCreditApplication() {
        return creditApplication;
    }

    public void setCreditApplication(CreditApplication creditApplication) {
        this.creditApplication = creditApplication;
    }
}
