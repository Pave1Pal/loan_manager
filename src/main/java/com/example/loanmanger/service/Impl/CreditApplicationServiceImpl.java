package com.example.loanmanger.service.Impl;

import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.exception.ApplicationNotCreatedException;
import com.example.loanmanger.exception.ApplicationNotFoundException;
import com.example.loanmanger.repository.CreditApplicationRepository;
import com.example.loanmanger.service.CreditApplicationService;
import com.example.loanmanger.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CreditApplicationServiceImpl implements CreditApplicationService {

    @Autowired
    public CreditApplicationServiceImpl(CustomerService customerService,
                                        CreditApplicationRepository creditApplicationRepository) {
        this.customerService = customerService;
        this.creditApplicationRepository = creditApplicationRepository;
    }

    private final CustomerService customerService;
    private final CreditApplicationRepository creditApplicationRepository;

    @Override
    @Transactional
    public CreditApplication create(CreditApplication application) {
        return Optional.of(application)
                .map(this::getPassportCode)
                .map(customerService::getOptionalByPassportCode)
                .map(customer -> {
                    customer.ifPresent(application::setCustomer);
                    return application;})
                .map(creditApplicationRepository::save)
                .orElseThrow(ApplicationNotCreatedException::new);
    }

    private String getPassportCode(CreditApplication application){
        return application.getCustomer().getPassport().getCode();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CreditApplication> getAcceptedIsTrue(Pageable pageable) {
        return Optional.of(pageable)
                .map(creditApplicationRepository::findByAcceptedIsTrue)
                .filter(application -> !application.isEmpty())
                .orElseThrow(() -> new ApplicationNotFoundException("No accepted application"));
    }

    @Override
    public CreditApplication getById(Long id) {
        return creditApplicationRepository.findById(id)
                .orElseThrow(ApplicationNotFoundException::new);
    }
}
