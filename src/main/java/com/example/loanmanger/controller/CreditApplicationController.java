package com.example.loanmanger.controller;

import com.example.loanmanger.domain.dto.CreateApplicationDto;
import com.example.loanmanger.domain.entity.CreditApplication;
import com.example.loanmanger.domain.entity.CreditContract;
import com.example.loanmanger.domain.entity.constants.Currency;
import com.example.loanmanger.domain.entity.constants.FamilyStatus;
import com.example.loanmanger.mapper.ApplicationMapper;
import com.example.loanmanger.mapper.ContractMapper;
import com.example.loanmanger.service.CreditApplicationService;
import com.example.loanmanger.service.CreditManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@SessionAttributes("contractDto")
@RequestMapping("credit-applications")
public class CreditApplicationController {

    @Autowired
    public CreditApplicationController(ApplicationMapper applicationMapper,
                                       CreditManager creditManager,
                                       ContractMapper contractMapper,
                                       CreditApplicationService applicationService) {
        this.applicationMapper = applicationMapper;
        this.creditManager = creditManager;
        this.contractMapper = contractMapper;
        this.applicationService = applicationService;
    }

    private final ApplicationMapper applicationMapper;
    private final CreditManager creditManager;
    private final ContractMapper contractMapper;
    private final CreditApplicationService applicationService;

    @GetMapping(path = "form")
    public String getForm(Model model) {
        model.addAttribute("applicationDto", new CreateApplicationDto());
        model.addAttribute("familyStatuses", FamilyStatus.values());
        model.addAttribute("currencies", Currency.values());
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

    @GetMapping(path = "accepted")
    public String getAcceptedApplications(Model model,
                                          @PageableDefault(size = 5) Pageable pageable) {
        Page<CreditApplication> acceptedApplications = applicationService.getAcceptedIsTrue(pageable);
        model.addAllAttributes(Map.of(
                "applications", acceptedApplications.getContent(),
                "totalPages", acceptedApplications.getTotalPages(),
                "nextPage", pageable.getPageNumber()+1,
                "pageNumber", pageable.getPageNumber(),
                "previousPage", pageable.getPageNumber()-1)
        );
        return "application/accepted";
    }
}
