package com.najot.oddiyauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @GetMapping
    public String getProduct(){
        return "product list";
    }

    @PostMapping
    public String createProduct(){
        return "create new product ";
    }
}
