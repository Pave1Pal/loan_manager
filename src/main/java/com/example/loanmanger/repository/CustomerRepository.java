package com.example.loanmanger.repository;

import com.example.loanmanger.domain.entity.Customer;
import com.example.loanmanger.domain.entity.embadable.FullName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByPassportCode(String code);

    Optional<Customer> findByPhoneNumber(String phoneNumber);

    Optional<Customer> findByFullName(FullName fullName);
}
