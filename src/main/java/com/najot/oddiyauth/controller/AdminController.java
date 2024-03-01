package com.najot.oddiyauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    private static final  String URL = "/api/v1/admin";
    @RequestMapping(URL)
    public ModelAndView getAdmin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin");
        return mv;
    }
}
