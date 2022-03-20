package com.example.loanmanger.domain.entity;

import com.example.loanmanger.domain.entity.embadable.FullName;
import com.example.loanmanger.domain.entity.embadable.Job;
import com.example.loanmanger.domain.entity.embadable.Passport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

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
            fetch = FetchType.LAZY,
            cascade = {DETACH, MERGE, PERSIST, REFRESH})
    private List<CreditApplication> creditApplications = new ArrayList<>();

    @OneToMany(mappedBy = "customer",
            fetch = FetchType.LAZY)
    private List<CreditContract> creditContracts = new ArrayList<>();

    public void addApplication(CreditApplication application) {
        this.creditApplications.add(application);
    }

    public void addContract(CreditContract contract) {
        this.creditContracts.add(contract);
    }

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

    @Override
    public String toString() {
        return  "full name: " + "\n" + fullName + "\n" +
                "phone number: " + phoneNumber + "\n" +
                "passport: " + "\n" + passport + "\n" +
                "job: " + "\n" + job ;
    }
}
