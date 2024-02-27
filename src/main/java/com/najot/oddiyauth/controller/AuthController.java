package com.najot.oddiyauth.controller;

import com.najot.oddiyauth.entity.User;
import com.najot.oddiyauth.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final MyUserService myUserService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public User signup(@RequestBody User user){
        return myUserService.create(user);
    }
}
