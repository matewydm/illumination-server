package com.darenie.controllers.form;

import com.darenie.database.model.AddressData;
import com.darenie.database.model.LampModuleData;
import com.darenie.database.model.LightLampData;

import java.util.List;

public class LampCreateForm {

    private LightLampData lightLampData;

    public LampCreateForm(LightLampData lightLampData) {
        AddressData addressData = new AddressData();
        this.lightLampData = lightLampData;
        this.lightLampData.setAddressData(addressData);
    }

    public String getName() {
        return lightLampData.getName();
    }

    public void setName(String name) {
        lightLampData.setName(name);
    }

    public String getDescription() {
        return lightLampData.getDescription();
    }

    public void setDescription(String description) {
        lightLampData.setDescription(description);
    }

    public AddressData getAddressData() {
        return lightLampData.getAddressData();
    }

    public Double getLatitude() {
        return getAddressData().getLatitude();
    }

    public String getCountry() {
        return getAddressData().getCountry();
    }

    public String getCity() {
        return getAddressData().getCity();
    }

    public String getStreet() {
        return getAddressData().getStreet();
    }


    public Double getLongitude() {
        return getAddressData().getLongitude();
    }

    public void setLatitude(Double latitude) {
        getAddressData().setLatitude(latitude);
    }

    public void setLongitude(Double longitude) {
        getAddressData().setLongitude(longitude);
    }

    public void setCountry(String country) {
        getAddressData().setCountry(country);
    }

    public void setCity(String city) {
        getAddressData().setCity(city);
    }


    public void setStreet(String street) {
        getAddressData().setStreet(street);
    }

    public String getStatus() {
        return lightLampData.getStatus();
    }

    public void setStatus(String status) {
        lightLampData.setStatus(status);
    }

    public LampModuleData getLampModuleData() {
        return lightLampData.getLampModuleData();
    }

    public void setLampModuleData(LampModuleData lampModuleData) {
        lightLampData.setLampModuleData(lampModuleData);
    }

    public Integer getLampModuleNumber() {
        return lightLampData.getLampModuleNumber();
    }

    public void setLampModuleNumber(Integer lampModuleNumber) {
        lightLampData.setLampModuleNumber(lampModuleNumber);
    }

    public LightLampData getLightLampData() {
        return lightLampData;
    }
}
