package com.darenie.controllers.form.validator;

import com.darenie.controllers.form.LightLampForm;
import com.darenie.controllers.form.TimeLineWrapper;
import com.darenie.controllers.form.TimeScheduleForm;
import com.darenie.database.model.TimeLineData;
import com.darenie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LightLampFormValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return LightLampForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        LightLampForm lightLampForm = (LightLampForm) o;

        if (!isDateValid(lightLampForm.getTimes())) {
            errors.rejectValue("times", "Incorrect.lighLampForm.invalidDate");
        }

    }

    private boolean isDateValid(List<TimeScheduleForm> timeLineData)  {
        for (TimeScheduleForm timeSchedule : timeLineData) {

            List<TimeLineWrapper> notNullWrapers = timeSchedule.getTimeLine().stream()
                    .filter(time -> (time.getStartTime() != null && time.getEndTime() != null))
                    .collect(Collectors.toList());
            List<TimeLineWrapper> timeLineWrappers = notNullWrapers.stream()
                    .filter(time -> time.getStartTime().after(time.getEndTime()))
                    .collect(Collectors.toList());
            if (timeLineWrappers != null && !timeLineWrappers.isEmpty()) {
                return false;
            }

            List<TimeLineWrapper> sortedLineWrapper = notNullWrapers.stream()
                    .sorted(Comparator.comparing(TimeLineWrapper::getStartTime))
                    .collect(Collectors.toList());
            for (int i = 0; i < (sortedLineWrapper.size() - 1); i++) {
                if (sortedLineWrapper.get(i).getEndTime().after(sortedLineWrapper.get(i+1).getStartTime())){
                    return false;
                }
            }
        }
        return true;
    }
}
