package com.example.loanmanger.service.Impl;

import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.exception.ApplicationNotFoundException;
import com.example.loanmanger.repository.CreditApplicationRepository;
import com.example.loanmanger.service.CreditApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditApplicationServiceImpl implements CreditApplicationService {

    @Autowired
    public CreditApplicationServiceImpl(CreditApplicationRepository creditApplicationRepository) {
        this.creditApplicationRepository = creditApplicationRepository;
    }

    private final CreditApplicationRepository creditApplicationRepository;

    @Override
    @Transactional
    public CreditApplication create(CreditApplication application) {
        return creditApplicationRepository.save(application);
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
}
