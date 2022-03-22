package com.example.loanmanger.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleTreatmentNotFoundException(HttpServletRequest request, Exception exception) {
        ModelAndView modelAndView = new ModelAndView("error/exception");
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("url", request.getRequestURI());
        return modelAndView;
    }
}
