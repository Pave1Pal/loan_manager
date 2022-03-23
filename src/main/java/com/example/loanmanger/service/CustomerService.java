package com.example.loanmanger.service;

import com.example.loanmanger.domain.entity.Customer;
import com.example.loanmanger.domain.entity.embadable.FullName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CustomerService {

    Optional<Customer> getOptionalByPassportCode(String code);

    Customer getByPassportCode(String code);

    Customer getByPhoneNumber(String phoneNumber);

    Page<Customer> getByFullName(FullName fullName, Pageable pageable);

    Page<Customer> getAllCustomers(Pageable pageable);

    Customer getById(Long id);
}
