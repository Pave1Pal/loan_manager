package com.example.loanmanger.domain.entity.constants;

public enum Currency {
    RUB("rub"),
    USD("usd")
    ;

    Currency(String displayName) {
        this.displayName = displayName;
    }

    private final String displayName;

    public String getDisplayName() {
        return displayName;
    }
}
