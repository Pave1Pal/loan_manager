package com.example.loanmanger.controller;

import com.example.loanmanger.domain.dto.CreditContractDto;
import com.example.loanmanger.mapper.ContractMapper;
import com.example.loanmanger.service.CreditContractService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("contractDto")
@RequestMapping("credit-contracts")
public class CreditContractController {

    public CreditContractController(ContractMapper contractMapper, CreditContractService contractService) {
        this.contractMapper = contractMapper;
        this.contractService = contractService;
    }

    private final ContractMapper contractMapper;
    private final CreditContractService contractService;

    @GetMapping(path = "form")
    public String getForm() {
        return "contract/form";
    }

    @PostMapping
    public String createContract(@ModelAttribute("contractDto") CreditContractDto contractDto) {
        Optional.of(contractDto)
                .map(contractMapper::formDto)
                .map(contractService::create)
                .orElseThrow();
        return "redirect:credit-contracts/creation-finish";
    }

    @GetMapping("creation-finish")
    public String getCreationFinishView() {
        return "contract/creation_finish";
    }

    @GetMapping(path = "accepted")
    public String getAccepted(Model model, @PageableDefault(size = 3) Pageable pageable) {
        Optional.of(pageable)
                .map(contractService::getAcceptedByUser)
                .map(contracts -> model.addAttribute("contracts", contracts))
                .orElseThrow();
        return "contract/contracts";
    }
}
