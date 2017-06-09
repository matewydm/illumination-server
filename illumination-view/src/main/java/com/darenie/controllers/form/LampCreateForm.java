package com.darenie.controllers.form;

import com.darenie.database.model.AddressData;
import com.darenie.database.model.LampModuleData;
import com.darenie.database.model.LightLampData;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;

public class LampCreateForm {

    public LampCreateForm() {
        this(new LightLampData());
    }

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

    @Range(min = -90, max = 90)
    public Double getLatitude() {
        return getAddressData().getLatitude();
    }

    @Size(max = 3)
    public String getCountry() {
        return getAddressData().getCountry();
    }

    public String getCity() {
        return getAddressData().getCity();
    }

    public String getStreet() {
        return getAddressData().getStreet();
    }

    @Range(min = -180, max = 180)
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
