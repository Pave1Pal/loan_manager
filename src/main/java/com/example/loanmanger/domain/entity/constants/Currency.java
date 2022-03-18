package com.example.loanmanger.domain.entity.constants;

public enum Currency {
    RUB("rub")
    ;

    Currency(String displayName) {
        this.displayName = displayName;
    }

    private final String displayName;

    public String getDisplayName() {
        return displayName;
    }
}
