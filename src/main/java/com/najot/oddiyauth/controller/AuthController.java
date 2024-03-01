package com.najot.oddiyauth.controller;

import com.najot.oddiyauth.dto.LoginDTO;
import com.najot.oddiyauth.entity.Permission;
import com.najot.oddiyauth.entity.Role;
import com.najot.oddiyauth.entity.User;
import com.najot.oddiyauth.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private static final String URL = "/api/v1/auth";
    private final MyUserService myUserService;
    private final AuthenticationManager authenticationManager;

    @RequestMapping(value = URL + "/signup-page",method = RequestMethod.GET)
    public ModelAndView signUpPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signup");
        return mv;
    }
    @RequestMapping(value = URL + "/signup",method = RequestMethod.POST)
    public ModelAndView signUp(@RequestParam("username") String username,@RequestParam("password") String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Role role = new Role();
        role.setRoleName("ADMIN");
        ArrayList<Permission> permissions = new ArrayList<>();
        Permission permission = new Permission();
        permission.setPermissionName("CREATE_PRODUCT");
        permissions.add(permission);
        user.setRole(role);
        user = myUserService.create(user);
        ModelAndView mv = new ModelAndView("redirect:/api/v1/home");
        mv.addObject("user",user);
        return mv;
    }

    @RequestMapping(value = URL + "/login",method = RequestMethod.POST)
    public ModelAndView signIn(@RequestBody LoginDTO loginDTO){
        myUserService.signIn(loginDTO.getUsername(), loginDTO.getPassword());
        ModelAndView mv = new ModelAndView("redirect:/api/v1/home");
        return mv;
    }
    @RequestMapping(value = URL + "/login-page",method = RequestMethod.GET)
    public ModelAndView signIn(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }





}
