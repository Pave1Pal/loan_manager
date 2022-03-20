package com.example.loanmanger.controller;

import com.example.loanmanger.domain.entity.CreditContract;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("contractDto")
@RequestMapping("credit-contracts")
public class CreditContractController {

    @GetMapping(path = "form")
    public String getForm(Model model) {
        model.addAttribute("contractDto", new CreditContract());
        return "contract/form";
    }

}
