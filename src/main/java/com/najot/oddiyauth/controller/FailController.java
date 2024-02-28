package com.najot.oddiyauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fail")
public class FailController {
    @GetMapping
    public String fail(){
        return "Fail";
    }
}
