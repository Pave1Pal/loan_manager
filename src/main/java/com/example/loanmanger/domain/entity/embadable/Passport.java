package com.example.loanmanger.domain.entity.embadable;

import com.example.loanmanger.domain.entity.constants.FamilyStatus;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Embeddable
public class Passport {

    @NotBlank
    @Column(name = "passport_place_of_issuance")
    private String placeOfIssuance;

    @NotBlank
    @Pattern(regexp = "^([0-9]{6})?$")
    @Column(name = "passport_code")
    private String code;

    @NotBlank
    @Pattern(regexp = "^([0-9]{3}[-]{1}[0-9]{3})?$")
    @Column(name = "passport_department_code")
    private String departmentCode;

    @NotBlank
    private String address;

    @NotNull
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

    @Override
    public String toString() {
        return  "place of issuance: " + placeOfIssuance  + "\n" +
                "code: " + code + "\n" +
                "department code: " + departmentCode + "\n" +
                "address: " + address + "\n" +
                "family status: " + familyStatus.toString().toLowerCase();
    }
}
