package com.darenie.controllers;

import com.darenie.controllers.form.RegisterForm;
import com.darenie.controllers.form.validator.RegisterFormValidator;
import com.darenie.database.dao.RoleDao;
import com.darenie.database.model.Role;
import com.darenie.database.model.User;
import com.darenie.json.model.RoleJson;
import com.darenie.json.model.UserJson;
import com.darenie.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({ViewController.REGISTER_FORM,
                    ViewController.ROLES})
public class ViewController {

    public static final String REGISTER_FORM = "REGISTER_FORM";
    public static final String ROLES = "ROLES";

    @Autowired
    private RegisterFormValidator registerFormValidator;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleDao roleDao;
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

        User user = new User();
        RegisterForm registerForm = new RegisterForm(user);
        model.addAttribute(REGISTER_FORM,registerForm);

        List<Role> roles = roleDao.findAll();
        model.addAttribute(ROLES,roles);

        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerSubmit(ServletRequest request, ServletResponse response,
                                 @Valid @ModelAttribute(name = REGISTER_FORM) RegisterForm registerForm,
                                 BindingResult r, Model m, BindingResult bindingResult){

        registerFormValidator.validate(registerForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        List<RoleJson> roles = userService.getRolesByIds(registerForm.getRoleIds());
        User user = registerForm.getUser();
        UserJson userJson = modelMapper.map(user,UserJson.class);
        userJson.setRoles(roles);

        userService.save(userJson);

        return "redirect:/";
    }
}
