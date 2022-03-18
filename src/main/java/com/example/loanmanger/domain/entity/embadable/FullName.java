package com.example.loanmanger.domain.entity.embadable;

import javax.persistence.Embeddable;

@Embeddable
public class FullName {

    private String firstName;
    private String lastLast;
    private String middleName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastLast() {
        return lastLast;
    }

    public void setLastLast(String lastLast) {
        this.lastLast = lastLast;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
