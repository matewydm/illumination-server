package com.darenie.controllers.form;

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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
        if (registerForm.getLogin().length() < 4 || registerForm.getLogin().length() > 32) {
            errors.rejectValue("login", "Size.registerForm.login");
        }
        if (userService.findByUsrLogin(registerForm.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.registerForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (registerForm.getPassword().length() < 4 || registerForm.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.registerForm.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleIds", "NotEmpty");
        if (registerForm.getRoleIds() == null || registerForm.getRoleIds().isEmpty()) {
            errors.rejectValue("roleIds", "Size.registerForm.roleIds");
        }

    }
}
