package com.example.loanmanger.domain.entity.embadable;

import javax.persistence.Embeddable;

@Embeddable
public class FullName {

    private String firstName;
    private String surname;
    private String middleName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return firstName + " " + surname + " " + middleName;
    }

}
