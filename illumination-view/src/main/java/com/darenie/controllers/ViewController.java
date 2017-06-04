package com.darenie.controllers;

import com.darenie.controllers.form.LightLampForm;
import com.darenie.controllers.form.RegisterForm;
import com.darenie.controllers.form.RegisterFormValidator;
import com.darenie.database.model.Role;
import com.darenie.database.model.User;
import com.darenie.json.model.LightLampDataJson;
import com.darenie.json.model.RoleJson;
import com.darenie.json.model.UserJson;
import com.darenie.service.LightLampService;
import com.darenie.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(ViewController.REGISTER_FORM)
public class ViewController {

    public static final String REGISTER_FORM = "REGISTER_FORM";
    private static final String ROLES = "ROLES";

    @Autowired
    private RegisterFormValidator registerFormValidator;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageSource ms;
    @Autowired
    private ModelMapper modelMapper;

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

    @RequestMapping(value = "/register",method = RequestMethod.GET)
        public String registerForm(Model model){

        UserJson user = new UserJson();
        RegisterForm registerForm = new RegisterForm(user);
        model.addAttribute(REGISTER_FORM,registerForm);

        List<RoleJson> roles = userService.getAllRoles();
        model.addAttribute(ROLES,roles);

        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerSubmit(ServletRequest request, ServletResponse response,
                                 @Valid @ModelAttribute(name = REGISTER_FORM) RegisterForm registerForm,
                                 BindingResult r, Model m, BindingResult bindingResult){

        registerFormValidator.validate(registerForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return registerForm(m);
        }

        List<RoleJson> roles = userService.getRolesByIds(registerForm.getRoleIds());
        UserJson user = registerForm.getUser();
        user.setRoles(roles);

        userService.save(user);

        return "redirect:/";
    }
}
