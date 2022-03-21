package com.example.loanmanger.repository;

import com.example.loanmanger.domain.entity.Customer;
import com.example.loanmanger.domain.entity.embadable.FullName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByPassportCode(String code);

    Optional<Customer> findByPassportCode(String code);

    Optional<Customer> findByPhoneNumber(String phoneNumber);

    Page<Customer> findByFullName(FullName fullName, Pageable pageable);

    Page<Customer> findByFullNameFirstNameAndFullNameSurname(String firstName, String surName, Pageable pageable);
}
