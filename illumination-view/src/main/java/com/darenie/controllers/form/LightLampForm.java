package com.darenie.controllers.form;

import com.darenie.database.model.LightLampData;

import javax.validation.constraints.NotNull;


public class LightLampForm {

    private LightLampData lamp;

    public LightLampForm(LightLampData lamp) {
        this.lamp = lamp;
    }


    public Long getId() {
        return lamp.getId();
    }

    @NotNull
    public String getName() {
        return lamp.getName();
    }

    public void setName(String name) {
        lamp.setName(name);
    }

    public String getStatus() {
        return lamp.getStatus();
    }


}
