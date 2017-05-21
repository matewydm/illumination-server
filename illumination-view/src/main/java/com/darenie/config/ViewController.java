package com.darenie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {


    @Autowired
    private MessageSource ms;

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
