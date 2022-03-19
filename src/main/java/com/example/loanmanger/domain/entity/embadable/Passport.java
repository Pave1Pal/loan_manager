package com.example.loanmanger.domain.entity.embadable;

import com.example.loanmanger.domain.entity.constants.FamilyStatus;

import javax.persistence.*;

@Embeddable
public class Passport {

    private String placeOfIssuance;

    private String code;

    private String departmentCode;

    private String address;

    @Enumerated(EnumType.STRING)
    private FamilyStatus familyStatus;

    public String getPlaceOfIssuance() {
        return placeOfIssuance;
    }

    public void setPlaceOfIssuance(String placeOfIssuance) {
        this.placeOfIssuance = placeOfIssuance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public FamilyStatus getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(FamilyStatus familyStatus) {
        this.familyStatus = familyStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}