package com.example.loanmanger.controller;

import com.example.loanmanger.domain.dto.CreateApplicationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("credit-applications")
public class CreditApplicationController {

    @GetMapping(path = "form")
    public String getForm(Model model) {
        model.addAttribute("applicationDto", new CreateApplicationDto());
        return "application/form";
    }
}
