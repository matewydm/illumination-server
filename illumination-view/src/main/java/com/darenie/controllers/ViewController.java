package com.darenie.controllers;

import com.darenie.json.model.LightLampDataJson;
import com.darenie.service.LightLampService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public ModelAndView lampMap(){

        ModelAndView model = new ModelAndView("map");
        ObjectMapper mapper = new ObjectMapper();

        List<LightLampDataJson> lightLampDataJsons = lightLampService.getAll();

        try {
            String jsonString = mapper.writeValueAsString(lightLampDataJsons);
            model.addObject("lightMapList", jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return model;
    }
}
