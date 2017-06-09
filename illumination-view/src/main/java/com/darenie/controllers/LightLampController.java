package com.darenie.controllers;

import com.darenie.controllers.form.LightLampForm;
import com.darenie.controllers.form.TimeLineWrapper;
import com.darenie.controllers.form.TimeScheduleForm;
import com.darenie.database.dao.LightLampDataRepository;
import com.darenie.database.model.LightLampData;
import com.darenie.database.model.TimeLineData;
import com.darenie.json.model.LightLampDataJson;
import com.darenie.service.LightLampService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;
import java.beans.PropertyEditor;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.List;
import java.util.function.Function;

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
    public String loadLightCIForm(ServletRequest request, ServletResponse responses, Model m, @PathVariable("id") Long lampId) {
        LightLampData l = lightLampDataRepository.getOne(lampId);

        LightLampForm form = new LightLampForm(l);
        m.addAttribute(LIGHT_LAMP_FORM, form);
        m.addAttribute("cudo", "abcd");
        return "lampForm";


    }


    @RequestMapping("/lamp/views")
    public String viewAllLamp(ServletRequest request, ServletResponse responses, Model m) {
        List<LightLampData> allLamps = lightLampDataRepository.findAll();
        m.addAttribute("LAMPS", allLamps);
        return "lampView";

    }

    @RequestMapping("/module/views")
    public String viewAllModule(ServletRequest request, ServletResponse responses, Model m) {
        List<LightLampData> allLamps = lightLampDataRepository.findAll();
        m.addAttribute("LAMPS", allLamps);
        return "lampView";

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createLightCi(ServletRequest request, ServletResponse response,
                                @Valid @ModelAttribute(LIGHT_LAMP_FORM) LightLampForm form,
                                BindingResult r, Model m) {
        List<TimeLineData> time = new ArrayList<>();
        for (TimeScheduleForm td : form.getTimes()) {
            int day = td.getDay().getValue();
            for (TimeLineWrapper wrapper : td.getTimeLine()) {
                if (wrapper.getStartTime() != null && wrapper.getEndTime() != null) {
                    TimeLineData data = new TimeLineData();
                    data.setDayOfWeek(day);
                    data.setStartTime(wrapper.getStartTime());
                    data.setEndTime(wrapper.getEndTime());
                    time.add(data);
                }
            }
        }
        lightLampService.updateLampLightDateWithTimeLineData(time,form.getId());
        return "redirect:/";
    }


    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String lampMap(Model model) {

        ObjectMapper mapper = new ObjectMapper();

        List<LightLampDataJson> lightLampDataJsons = lightLampService.getAll();

        try {
            String lampListString = mapper.writeValueAsString(lightLampDataJsons);
            model.addAttribute("lightMapList", lampListString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        model.addAttribute("BROKEN", LightLampDataJson.Status.BROKEN);
        model.addAttribute("WORKING", LightLampDataJson.Status.WORKING);
        model.addAttribute("NOT_WORKING", LightLampDataJson.Status.NOT_WORKING);

        return "lightMap";
    }



    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        PropertyEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }


}
