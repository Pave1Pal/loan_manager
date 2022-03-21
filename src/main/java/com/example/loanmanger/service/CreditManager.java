package com.example.loanmanger.service;

import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.domain.entity.CreditContract;

/**
 * Makes decisions about accepted or denied application
 * and set credit application and credit contract properties
 */
public interface CreditManager {

    /**
     * Set status and application fields for application.
     * Build contract if application accepted, else build false contract,
     * which does not use in future flow.
     *
     * @param application credit application
     * @return Credit contract if application is accepted, else false
     *         credit contract which does not use in future flow.
     */
    CreditContract setStatusAndGetContract(CreditApplication application);
}
