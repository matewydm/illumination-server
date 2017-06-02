package com.darenie.controllers;

import com.darenie.controllers.form.LightLampForm;
import com.darenie.database.dao.LightLampDataRepository;
import com.darenie.database.model.LightLampData;
import com.darenie.json.model.LightLampDataJson;
import com.darenie.service.LightLampService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes(LightLampController.LIGHT_LAMP_FORM)
@RequestMapping("/light")
public class LightLampController {

    public static final String LIGHT_LAMP_FORM = "LIGHT_LAMP_FORM";

    @Autowired
    private LightLampService lightLampService;
    @Autowired
    private LightLampDataRepository lightLampDataRepository;

    @RequestMapping("/create/{id}")
    public String loadLightCIForm(ServletRequest request, ServletResponse responses, Model m, @PathVariable("id") Long lampId){
        LightLampData l =lightLampDataRepository.getOne(lampId);

        LightLampForm form = new LightLampForm(l);
        m.addAttribute(LIGHT_LAMP_FORM,form);
        return "lampForm";

    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createLightCi(ServletRequest request, ServletResponse response,
                                @Valid @ModelAttribute(LIGHT_LAMP_FORM)LightLampForm form, BindingResult r, Model m){

        return "redirect:/";
    }


    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String lampMap(Model model){

        ObjectMapper mapper = new ObjectMapper();

        List<LightLampDataJson> lightLampDataJsons = lightLampService.getAll();

        try {
            String lampListString = mapper.writeValueAsString(lightLampDataJsons);
            model.addAttribute("lightMapList", lampListString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        model.addAttribute("BROKEN",LightLampDataJson.Status.BROKEN);
        model.addAttribute("WORKING",LightLampDataJson.Status.WORKING);
        model.addAttribute("NOT_WORKING",LightLampDataJson.Status.NOT_WORKING);

        return "lightMap";
    }
}
