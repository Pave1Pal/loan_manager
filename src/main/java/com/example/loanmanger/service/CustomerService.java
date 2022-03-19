package com.example.loanmanger.service;

import com.example.loanmanger.domain.entity.Customer;
import com.example.loanmanger.domain.entity.embadable.FullName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface CustomerService {

    boolean isExist(Customer customer);

    Customer create(Customer customer);

    Customer getByPassportCode(String code);

    Customer getByPhoneNumber(String phoneNumber);

    Page<Customer> getByFullName(FullName fullName, Pageable pageable);

    Page<Customer> getByFirstNameAndSurname(String firstName, String surName, Pageable pageable);

    Customer update(Customer customer);
}
