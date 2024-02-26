package com.najot.oddiyauth.controller;

import com.najot.oddiyauth.entity.User;
import com.najot.oddiyauth.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final MyUserService myUserService;

    @PostMapping
    public User signup(@RequestBody User user){
        return myUserService.create(user);
    }
}
