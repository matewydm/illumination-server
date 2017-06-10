package com.darenie.controllers.form;

import com.darenie.database.model.LampModuleData;
import com.darenie.database.model.LightLampData;

import java.util.List;
import java.util.stream.Collectors;

public class ModuleDetailsForm {

    private LampModuleData lampModuleData;
    private List<LampDetailsForm> lampDetailsForms;

    public ModuleDetailsForm(LampModuleData lampModuleData) {
        this.lampModuleData = lampModuleData;
        this.lampDetailsForms = lampModuleData.getLampDataList().stream().map(LampDetailsForm::new).collect(Collectors.toList());
    }

    public Long getId() {
        return lampModuleData.getId();
    }

    public String getName() {
        return lampModuleData.getName();
    }

    public String getIpAddress() {
        return lampModuleData.getIpAddress();
    }

    public String getDescription() {
        return lampModuleData.getDescription();
    }

    public Integer getPort() {
        return lampModuleData.getPort();
    }


    public List<LampDetailsForm> getLampDetailsForms() {
        return lampDetailsForms;
    }
}
