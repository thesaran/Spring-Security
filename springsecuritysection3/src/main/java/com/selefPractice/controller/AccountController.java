package com.selefPractice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccounts")
    public String welcome () {

    return "This is my Account XXXXXXX2344"; }

}
