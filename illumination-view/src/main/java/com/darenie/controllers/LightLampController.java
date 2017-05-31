package com.darenie.controllers;

import com.darenie.controllers.form.LightLampForm;
import com.darenie.database.dao.LightLampDataRepository;
import com.darenie.database.model.LightLampData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;

@Controller
@SessionAttributes(LightLampController.LIGHT_LAMP_FORM)
public class LightLampController {



   public static final String LIGHT_LAMP_FORM = "LIGHT_LAMP_FORM";

   @Autowired
   private LightLampDataRepository lightLampDataRepository;

    @RequestMapping("/light/create/{id}")
    public String loadLightCIForm(ServletRequest request, ServletResponse responses, Model m, @PathVariable("id") Long lampId){
        LightLampData l =lightLampDataRepository.getOne(lampId);


        LightLampForm form = new LightLampForm(l);
        m.addAttribute(LIGHT_LAMP_FORM,form);
        return "lampForm";

    }

    @RequestMapping(value = "/light/create",method = RequestMethod.POST)
    public String createLightCi(ServletRequest request, ServletResponse response,
                                @Valid @ModelAttribute(LIGHT_LAMP_FORM)LightLampForm form, BindingResult r, Model m){

        return "redirect:/";
    }


    @RequestMapping(value = "/light/map")
    public String lightMap(Model m){
        return "lightMap";
    }

}
