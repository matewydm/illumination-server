package com.darenie.controllers;

import com.darenie.controllers.form.*;
import com.darenie.database.dao.LampModuleDataRepository;
import com.darenie.database.dao.LightLampDataRepository;
import com.darenie.database.model.LampModuleData;
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

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;
import java.beans.PropertyEditor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({LightLampController.LIGHT_LAMP_FORM,
        LightLampController.CREATE_LAMP_FORM,LightLampController.CREATE_MODULE_FORM})
@RequestMapping("/light")
public class LightLampController {

    public static final String LIGHT_LAMP_FORM = "LIGHT_LAMP_FORM";
    public static final String CREATE_LAMP_FORM = "CREATE_LAMP_FORM";
    private static final String MODULES = "MODULES";
    private static final String STATUSES = "STATUSES";
    public static final String CREATE_MODULE_FORM = "CREATE_MODULE_FORM";

    @Autowired
    private LightLampService lightLampService;
    @Autowired
    private LightLampDataRepository lightLampDataRepository;
    @Autowired
    private LampModuleDataRepository lampModuleDataRepository;

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

    @RequestMapping("lamp/create")
    public String createLamp(ServletRequest request, ServletResponse responses, Model m) {

        List<LampModuleData> moduleDataList = lampModuleDataRepository.findAll();
        m.addAttribute(MODULES, moduleDataList);
        m.addAttribute(STATUSES, getStatuses());

        LightLampData lightLampData = new LightLampData();
        LampCreateForm lampCreateForm = new LampCreateForm(lightLampData);
        m.addAttribute(CREATE_LAMP_FORM, lampCreateForm);

        return "createLampForm";
    }
    @RequestMapping("/module/create")
    public String createModule(ServletRequest request, ServletResponse responses, Model m) {
        m.addAttribute(CREATE_MODULE_FORM,new ModuleCreateForm());
        return "createModuleForm";
    }

    @RequestMapping(value = "/module/create",method = RequestMethod.POST)
    public String createModule(ServletRequest reqeust, ServletResponse response,
                               @Valid @ModelAttribute(LightLampController.CREATE_MODULE_FORM) ModuleCreateForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "createModuleForm";
        }

        lampModuleDataRepository.save(form.getModule());
        return "redirect:/";
    }

    private List<String> getStatuses() {
        List<String> statusList = new ArrayList<>();
        statusList.add(LightLampDataJson.Status.NOT_WORKING);
        statusList.add(LightLampDataJson.Status.WORKING);
        statusList.add(LightLampDataJson.Status.BROKEN);
        return statusList;
    }


    @RequestMapping(value = "lamp/create",method = RequestMethod.POST)
    public String createLamp (ServletRequest request, ServletResponse response,
                              @Valid @ModelAttribute(CREATE_LAMP_FORM) LampCreateForm form,
                              Model model, BindingResult bindingResult){

//        registerFormValidator.validate(registerForm, bindingResult);

//        if (bindingResult.hasErrors()) {
//            return registerForm(model);
//        }

        lightLampDataRepository.save(form.getLightLampData());

        return "redirect:/";
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
