package com.daily.practice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value = "/test")
    public ModelAndView test() {
        System.out.println("qqqq");
        ModelAndView modelAndView = new ModelAndView("test");
        return modelAndView;
    }

    @RequestMapping(value = "/index")
    @ResponseBody
    public String index() {
        System.out.println("qqqq");
        return "index";
    }
}
