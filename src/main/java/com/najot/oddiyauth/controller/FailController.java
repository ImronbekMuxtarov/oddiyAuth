package com.najot.oddiyauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FailController {
    @RequestMapping("/fail")
    public ModelAndView fail(){
        ModelAndView mv = new ModelAndView("fail");
        return mv;
    }
}
