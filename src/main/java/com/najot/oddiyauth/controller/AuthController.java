package com.najot.oddiyauth.controller;

import com.najot.oddiyauth.dto.LoginDTO;
import com.najot.oddiyauth.entity.User;
import com.najot.oddiyauth.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
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
    public User signUp(@RequestBody User user){
        user = myUserService.create(user);
        return user;
    }

    @PostMapping("/login-post")
    public String signIn(@RequestBody LoginDTO loginDTO){
        myUserService.signIn(loginDTO.getUsername(), loginDTO.getPassword());
        return "redirect:/api/v1/home";
    }
    @GetMapping("/login")
    public String signIn(){
        return "login.jsp";
    }





}
