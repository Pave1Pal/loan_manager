package com.example.loanmanger.controller;

import com.example.loanmanger.domain.dto.CreateApplicationDto;
import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.domain.entity.CreditContract;
import com.example.loanmanger.mapper.ApplicationMapper;
import com.example.loanmanger.mapper.ContractMapper;
import com.example.loanmanger.service.CreditManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("contractDto")
@RequestMapping("credit-applications")
public class CreditApplicationController {

    @Autowired
    public CreditApplicationController(ApplicationMapper applicationMapper, CreditManager creditManager, ContractMapper contractMapper) {
        this.applicationMapper = applicationMapper;
        this.creditManager = creditManager;
        this.contractMapper = contractMapper;
    }

    private final ApplicationMapper applicationMapper;
    private final CreditManager creditManager;
    private final ContractMapper contractMapper;

    @GetMapping(path = "form")
    public String getForm(Model model) {
        model.addAttribute("applicationDto", new CreateApplicationDto());
        return "application/form";
    }

    @PostMapping
    public String createApplication(Model model,
                                    @ModelAttribute("applicationDto") CreateApplicationDto createDto) {
        CreditApplication application = applicationMapper.fromCreateDto(createDto);
        CreditContract contract = creditManager.getContract(application);
        model.addAttribute("contractDto", contractMapper.toDto(contract));
        return "redirect:" + "credit-contracts/form";
    }
}
