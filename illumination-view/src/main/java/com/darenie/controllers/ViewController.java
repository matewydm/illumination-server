package com.darenie.controllers;

import com.darenie.json.model.LightLampDataJson;
import com.darenie.service.LightLampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import java.util.List;

@Controller
public class ViewController {

    @Autowired
    private LightLampService lightLampService;
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

    @RequestMapping("/map")
    public String map(){
        return "map";
    }

    @RequestMapping("/lamps")
    public String lamps(){
        List<LightLampDataJson> lightLampDataJsons = lightLampService.getAll();

        return "dare";
    }
}
