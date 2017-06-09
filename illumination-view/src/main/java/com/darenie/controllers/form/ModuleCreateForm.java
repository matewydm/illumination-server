package com.darenie.controllers.form;

import com.darenie.database.model.LampModuleData;
import com.darenie.database.model.LightLampData;

import javax.validation.constraints.*;
import java.util.List;

public class ModuleCreateForm {
    @Size(min = 5)

    private String name;
    private String description;
//    @Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$")
    private String ipAddress;

    @NotNull
    @Min(1)
    @Max(65355)
    private Integer port;


    public ModuleCreateForm() {
    }



    @Size(min = 5)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public LampModuleData getModule() {
        LampModuleData module = new LampModuleData();
        module.setName(name);
        module.setDescription(description);
        module.setIpAddress(ipAddress);
        module.setPort(port);
        return module;
    }

}
