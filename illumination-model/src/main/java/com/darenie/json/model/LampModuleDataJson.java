package com.darenie.json.model;

public class LampModuleDataJson extends AbstractDataJson {

    private String ipAddress;
    private Integer port;

    public String getIpAddress() {
        return ipAddress;
    }

    public LampModuleDataJson setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public LampModuleDataJson setPort(Integer port) {
        this.port = port;
        return this;
    }
}
