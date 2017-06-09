package com.darenie.controllers.form.validator;

import com.darenie.controllers.form.LampCreateForm;
import com.darenie.database.dao.LightLampDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LampCreateFormValidator implements Validator {

    @Autowired
    private LightLampDataRepository lampDataDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return LampCreateForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    LampCreateForm lampCreateForm = (LampCreateForm) o;

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
    if (lampDataDao.findByNumberAndModule(lampCreateForm.getLampModuleNumber(),
            lampCreateForm.getLampModuleData().getId()) != null) {
        errors.rejectValue("lampModuleNumber", "Duplicate.lampCreateForm.lampModuleNumber");
    }

    if (lampDataDao.findByName(lampCreateForm.getName()) != null) {
        errors.rejectValue("lampName", "Duplicate.lampCreateForm.lampName");
    }

    }
}
