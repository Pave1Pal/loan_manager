package com.example.loanmanger.service.Impl;

import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.domain.entity.CreditContract;
import com.example.loanmanger.exception.CreditContractNotFoundException;
import com.example.loanmanger.repository.CreditContractRepository;
import com.example.loanmanger.service.CreditApplicationService;
import com.example.loanmanger.service.CreditContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditContractServiceImpl implements CreditContractService {

    @Autowired
    public CreditContractServiceImpl(CreditContractRepository creditContractRepository,
                                     CreditApplicationService creditApplicationService) {
        this.creditApplicationService = creditApplicationService;
        this.creditContractRepository = creditContractRepository;
    }

    private final CreditApplicationService creditApplicationService;
    private final CreditContractRepository creditContractRepository;


    @Override
    @Transactional
    public CreditContract create(CreditContract contract) {
        CreditApplication application = contract.getCreditApplication();
        creditApplicationService.update(application);
        return creditContractRepository.save(contract);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CreditContract> getAcceptedByUser(Pageable pageable) {
        Page<CreditContract> contracts = creditContractRepository.findByAcceptedByUserIsTrue(pageable);
        if (contracts.isEmpty()) {
            throw new CreditContractNotFoundException("No accepted contracts");
        }
        return contracts;
    }
}
