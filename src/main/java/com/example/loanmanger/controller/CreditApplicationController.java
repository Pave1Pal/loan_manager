package com.example.loanmanger.controller;

import com.example.loanmanger.domain.dto.CreateApplicationDto;
import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.domain.entity.CreditContract;
import com.example.loanmanger.mapper.ApplicationMapper;
import com.example.loanmanger.service.CreditManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("applicationDto")
@RequestMapping("credit-applications")
public class CreditApplicationController {

    @Autowired
    public CreditApplicationController(ApplicationMapper applicationMapper, CreditManager creditManager) {
        this.applicationMapper = applicationMapper;
        this.creditManager = creditManager;
    }

    private final ApplicationMapper applicationMapper;
    private final CreditManager creditManager;

    private static final String applicationDeniedPath = "credit-application/denied";
    private static final String applicationAcceptPath = "credit-contracts/form";


    @GetMapping(path = "form")
    public String getForm(Model model) {
        model.addAttribute("applicationDto", new CreateApplicationDto());
        return "application/form";
    }

    @PostMapping
    public String createApplication(Model model,
                                    @ModelAttribute("applicationDto") CreateApplicationDto createDto) {
        CreditApplication application = applicationMapper.fromCreateDto(createDto);
        CreditApplication reviewedApplication = creditManager.makeDecision(application);
        model.addAttribute("applicationDto", applicationMapper.toDto(reviewedApplication));
        String path = reviewedApplication.isAccepted() ? applicationAcceptPath : applicationDeniedPath;
        return "redirect:" + path;
    }
}
