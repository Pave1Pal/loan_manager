package com.example.loanmanger.service.Impl;

import com.example.loanmanger.domain.entity.CreditContract;
import com.example.loanmanger.exception.ContractNotCreated;
import com.example.loanmanger.exception.CreditContractNotFoundException;
import com.example.loanmanger.repository.CreditContractRepository;
import com.example.loanmanger.service.CreditContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CreditContractServiceImpl implements CreditContractService {

    @Autowired
    public CreditContractServiceImpl(CreditContractRepository creditContractRepository) {
        this.creditContractRepository = creditContractRepository;
    }

    private final CreditContractRepository creditContractRepository;


    @Override
    @Transactional
    public CreditContract create(CreditContract contract) {
        return Optional.of(contract)
                .filter(c -> c.getCreditApplication().isAccepted())
                .map(creditContractRepository::save)
                .orElseThrow(ContractNotCreated::new);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CreditContract> getAcceptedByUser(Pageable pageable) {
        return Optional.of(pageable)
                .map(creditContractRepository::findByAcceptedByUserIsTrue)
                .filter(contracts -> !contracts.isEmpty())
                .orElseThrow(() -> new CreditContractNotFoundException("No accepted contracts"));
    }
}
