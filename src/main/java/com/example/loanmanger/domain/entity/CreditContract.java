package com.example.loanmanger.domain.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@Table(name = "credit_contracts")
public class CreditContract extends BaseEntity{

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate singInDate;

    private boolean acceptedByUser;

    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(cascade = ALL)
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
