package org.example.springCourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class Calculator {
    @GetMapping("/calculator")
    public String calculation(@RequestParam(value = "a") int a,
                              @RequestParam(value = "b") int b,
                              @RequestParam("action") String action,
                              Model model) {
        double result;

        switch (action) {
            case ("addition"):
                result = a + b;
                break;
            case ("subtraction"):
                result = a - b;
                break;
            case ("miltiplication"):
                result = a * b;
                break;
            case ("division"):
                result = a / (double) b;
                break;
            default:
                result = 0;
        }
        model.addAttribute("result", result);
        return "first/calculator";

    }
}
