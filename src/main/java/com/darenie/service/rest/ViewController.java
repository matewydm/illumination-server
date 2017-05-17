package com.darenie.service.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/cudo")
    public String cudo(){
        return "e";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
