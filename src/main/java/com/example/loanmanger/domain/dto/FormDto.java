package com.example.loanmanger.domain.dto;

import com.example.loanmanger.domain.entity.embadable.FullName;

public class FormDto {

    private String phoneNumber;
    private String passportCode;
    private FullName fullName;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassportCode() {
        return passportCode;
    }

    public void setPassportCode(String passportCode) {
        this.passportCode = passportCode;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }
}
