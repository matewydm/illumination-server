package com.darenie.database.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@AttributeOverrides(value = {
        @AttributeOverride(name = "id",column = @Column(name = "lamp_module_id")),
        @AttributeOverride(name = "name",column = @Column(name = "lamp_module_name")),
        @AttributeOverride(name = "description",column = @Column(name = "lamp_module_description")),
})

public class LampModuleData extends AbstractData {

    private String ipAddress;
    private Integer port;
    private List<LightLampData> lampDataList;
    private Boolean isConnected;


    @Column(nullable = false)
    public String getIpAddress() {
        return ipAddress;
    }

    public LampModuleData setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }
    @Column(nullable = false)
    public Integer getPort() {
        return port;
    }

    public LampModuleData setPort(Integer port) {
        this.port = port;
        return this;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "lampModuleData")
    public List<LightLampData> getLampDataList() {
        return lampDataList;
    }

    public void setLampDataList(List<LightLampData> lampDataList) {
        this.lampDataList = lampDataList;
    }

    @Column(name = "is_connected")
    public Boolean getConnected() {
        return isConnected;
    }

    public void setConnected(Boolean connected) {
        isConnected = connected;
    }
}
