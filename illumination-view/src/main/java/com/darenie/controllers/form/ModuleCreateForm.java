package com.darenie.controllers.form;

import com.darenie.database.model.LampModuleData;
import com.darenie.database.model.LightLampData;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.List;

public class ModuleCreateForm {
    private LampModuleData module;


    public ModuleCreateForm(LampModuleData module) {
        this.module = module;
    }

    @Size(min=4)
    public String getName() {
        return module.getName();
    }

    public void setName(String name) {
        module.setName(name);
    }
    @NotNull
    @Pattern(regexp="^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$")
    public String getIpAddress() {
        return module.getIpAddress();
    }

    public String getDescription() {
        return module.getDescription();
    }

    public LampModuleData setIpAddress(String ipAddress) {
        return module.setIpAddress(ipAddress);
    }

    public void setDescription(String description) {
        module.setDescription(description);
    }
    @Range(min = 1,max = 65535)
    public Integer getPort() {
        return module.getPort();
    }

    public LampModuleData setPort(Integer port) {
        return module.setPort(port);
    }

    public LampModuleData getModule(){
        return module;
    }
}
