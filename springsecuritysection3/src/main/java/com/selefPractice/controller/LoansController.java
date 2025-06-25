package com.selefPractice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/loan")
    public String locanDetails () {

    return "This is my loan details "; }

}
