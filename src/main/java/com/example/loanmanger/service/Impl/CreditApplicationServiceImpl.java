package com.example.loanmanger.service.Impl;

import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.domain.entity.Customer;
import com.example.loanmanger.exception.ApplicationNotFoundException;
import com.example.loanmanger.repository.CreditApplicationRepository;
import com.example.loanmanger.service.CreditApplicationService;
import com.example.loanmanger.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Customer  customer = application.getCustomer();
        String passportCode = getPassportCode(application);
        customer = customerService.isExist(customer) ? getExistedCustomerBy(passportCode) : createCustomer(customer);
        application.setCustomer(customer);
        return creditApplicationRepository.save(application);
    }

    private Customer getExistedCustomerBy(String passportCode) {
        return customerService.getByPassportCode(passportCode);
    }

    private Customer createCustomer(Customer customer) {
        return  customerService.create(customer);
    }

    private String getPassportCode(CreditApplication application) {
        return application.getCustomer().getPassport().getCode();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CreditApplication> getAcceptedIsTrue(Pageable pageable) {
        Page<CreditApplication> applications = creditApplicationRepository.findByAcceptedIsTrue(pageable);
        if (applications.isEmpty()) {
            throw new ApplicationNotFoundException("No accepted application");
        }
        return applications;
    }

    @Override
    @Transactional
    public CreditApplication update(CreditApplication application) {
        customerService.update(application.getCustomer());
        return creditApplicationRepository.save(application);
    }
}
