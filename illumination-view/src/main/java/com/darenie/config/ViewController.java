package com.darenie.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;

@Controller
public class ViewController {


    @Autowired
    private MessageSource ms;

    @RequestMapping("/")
    public String index(Model m, ServletRequest request){
        return "index";
    }

    @RequestMapping("/blank")
    public String cudo(){
        return "blank";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
