package com.darenie.json.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class LightLampDataJson extends AbstractDataJson {

    @JsonIgnore
    private List<CronDataJson> cron;

    private AddressDataJson addressData;

    private String status;

    public AddressDataJson getAddressData() {
        return addressData;
    }

    public String getStatus() {
        return status;
    }

    public void setAddressData(AddressDataJson addressData) {
        this.addressData = addressData;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public interface Status {
        String WORKING = "W";
        String NOT_WORKING = "N";
        String BROKEN = "B";
    }

}