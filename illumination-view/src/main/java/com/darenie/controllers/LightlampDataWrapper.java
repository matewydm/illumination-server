package com.darenie.controllers;

import com.darenie.database.model.LightLampData;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class LightlampDataWrapper {
    LightLampData date;


    public Long getId() {
        return date.getId();
    }

    public String getName() {
        return date.getName();
    }

    public String getDescription() {
        return date.getDescription();
    }

    public String getStatus() {
        return date.getStatus();
    }

}
