package com.example.loanmanger.controller;

import com.example.loanmanger.domain.dto.FormDto;
import com.example.loanmanger.service.CustomerService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("customers")
public class CustomerController {

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private final CustomerService customerService;

    @GetMapping("find")
    public String find(Model model) {
        model.addAttribute("form", new FormDto());
        return "customer/find";
    }

    @GetMapping(path = "{id}")
    public String getById(Model model, @PathVariable("id") Long id) {
        Optional.of(id)
                .map(customerService::getById)
                .map(customer -> model.addAttribute("customer", customer))
                .orElseThrow();
        return "customer/customer";
    }

    @GetMapping(path = "phone-number")
    public String getByPhoneNumber(Model model, @ModelAttribute("form") FormDto form) {
        Optional.of(form.getPhoneNumber())
                .map(customerService::getByPhoneNumber)
                .map(customer -> model.addAttribute("customer", customer))
                .orElseThrow();
        return "customer/customer";
    }

    @GetMapping(path = "passport-code")
    public String getByPassportCode(Model model, @ModelAttribute("form") FormDto form) {
        Optional.of(form.getPassportCode())
                .map(customerService::getByPassportCode)
                .map(customer -> model.addAttribute("customer", customer))
                .orElseThrow();
        return "customer/customer";
    }

    @GetMapping
    public String getAllCustomers(Model model, @PageableDefault(size = 5) Pageable pageable) {
        Optional.of(pageable)
                .map(customerService::getAllCustomers)
                .map(customers -> model.addAllAttributes(Map.of(
                        "customers", customers.getContent(),
                        "totalPages", customers.getTotalPages(),
                        "pageNumber", pageable.getPageNumber(),
                        "nexPage", pageable.getPageNumber() + 1,
                        "previousPage", pageable.getPageNumber() - 1))
                )
                .orElseThrow();
        return "customer/customers";
    }

    @GetMapping("full-name")
    public String getByFullName(Model model, @PageableDefault Pageable pageable,
                                @ModelAttribute("form") FormDto form) {
        Optional.of(form.getFullName())
                .map(name -> customerService.getByFullName(name, pageable))
                .map(customers -> model.addAllAttributes(Map.of(
                        "customers", customers.getContent(),
                        "totalPages", customers.getTotalPages(),
                        "pageNumber", pageable.getPageNumber(),
                        "nexPage", pageable.getPageNumber() + 1,
                        "previousPage", pageable.getPageNumber() - 1))
                )
                .orElseThrow();
        return "customer/customers";
    }
}
