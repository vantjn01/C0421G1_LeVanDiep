package com.codegym.controller;

import com.codegym.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("/calculator")
    public String calculator(@RequestParam String firstNumber, @RequestParam String secondNumber, @RequestParam String operation, Model model){
        Float first = Float.parseFloat(firstNumber);
        Float second = Float.parseFloat(secondNumber);
        model.addAttribute("result",calculatorService.Calculator(first, second, operation));
        return "index";

    }
}
