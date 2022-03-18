package com.example.loanmanger.domain.entity;

import com.example.loanmanger.domain.entity.embadable.FullName;
import com.example.loanmanger.domain.entity.embadable.Job;
import com.example.loanmanger.domain.entity.embadable.Passport;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{

    @Embedded
    private FullName fullName;

    private String phoneNumber;

    @Embedded
    private Passport passport;

    @Embedded
    private Job job;

    @OneToMany(mappedBy = "customer",
            fetch = FetchType.LAZY)
    private List<CreditApplication> creditApplications;

    @OneToMany(mappedBy = "customer",
            fetch = FetchType.LAZY)
    private List<CreditContract> creditContracts;

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<CreditApplication> getCreditApplications() {
        return creditApplications;
    }

    public void setCreditApplications(List<CreditApplication> creditApplications) {
        this.creditApplications = creditApplications;
    }

    public List<CreditContract> getCreditContracts() {
        return creditContracts;
    }

    public void setCreditContracts(List<CreditContract> creditContracts) {
        this.creditContracts = creditContracts;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
