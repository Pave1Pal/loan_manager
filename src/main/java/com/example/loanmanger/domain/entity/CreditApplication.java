package com.example.loanmanger.domain.entity;

import com.example.loanmanger.domain.entity.embadable.Money;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@Table(name = "credit_applications")
public class CreditApplication extends BaseEntity {

    @Transient
    private Money desiredSum;

    @Embedded
    private Money acceptedSum;

    private boolean accepted;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate creationDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate expirationDate;

    private Integer days;

    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    private CreditContract creditContract;

    public Money getDesiredSum() {
        return desiredSum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDesiredSum(Money desiredSum) {
        this.desiredSum = desiredSum;
    }

    public Money getAcceptedSum() {
        return acceptedSum;
    }

    public void setAcceptedSum(Money sum) {
        this.acceptedSum = sum;
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

    public CreditContract getCreditContract() {
        return creditContract;
    }

    public void setCreditContract(CreditContract creditContract) {
        this.creditContract = creditContract;
    }

    @Override
    public String toString() {
        return  "accepted sum: " + acceptedSum + "\n" +
                "is accepted: " + accepted + "\n" +
                "creationDate=" + creationDate + "\n" +
                "expirationDate=" + expirationDate + "\n" +
                "days=" + days + "\n" +
                "customer " + customer + "\n" +
                ", creditContract=" + creditContract;
    }
}
