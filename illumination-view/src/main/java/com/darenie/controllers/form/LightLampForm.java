package com.darenie.controllers.form;

import com.darenie.database.model.LightLampData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class LightLampForm {

    private LightLampData lamp;
    List<TimeScheduleForm> times;
    public LightLampForm(LightLampData lamp) {
        this.lamp = lamp;
        times =Arrays.stream(DayOfWeek.values()).map(TimeScheduleForm::new).collect(Collectors.toList());


    }


    public Long getId() {
        return lamp.getId();
    }

    @NotNull
    @Size(min = 1)
    public String getName() {
        return lamp.getName();
    }

    public void setName(String name) {
        lamp.setName(name);
    }

    public String getStatus() {
        return lamp.getStatus();
    }

    public List<TimeScheduleForm> getTimes() {
        return times;
    }

    public void setTimes(List<TimeScheduleForm> times) {
        this.times = times;
    }
}
