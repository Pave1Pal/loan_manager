package com.example.loanmanger.domain.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "credit_contracts")
public class CreditContract extends BaseEntity{

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate singInDate;

    private boolean acceptedByUser;

    @ManyToOne
    private Customer customer;

    @OneToOne(mappedBy = "creditContract")
    private CreditApplication creditApplication;


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
}
