package com.darenie.controllers.form.validator;

import com.darenie.controllers.form.RegisterForm;
import com.darenie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import org.springframework.validation.Validator;


@Component
public class RegisterFormValidator implements Validator{

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return RegisterForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterForm registerForm = (RegisterForm) o;

        if (userService.findByUsrLogin(registerForm.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.registerForm.login");
        }

    }
}
