package com.darenie.database.model;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@AttributeOverrides(value = {
        @AttributeOverride(name = "id",column = @Column(name = "light_lamp_id")),
        @AttributeOverride(name = "name",column = @Column(name = "light_lamp_name")),
        @AttributeOverride(name = "description",column = @Column(name = "light_lamp_description")),
})
public class LightLampData extends AbstractData{

    private List<CronData> cron;

    private AddressData addressData;

    private String status;

    @OneToOne
    @JoinColumn(name = "address_data_id")
    public AddressData getAddressData() {
        return addressData;
    }

    @Column(length = 1)
    public String getStatus() {
        return status;
    }

    public void setAddressData(AddressData addressData) {
        this.addressData = addressData;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public interface Status{
        String WORKING ="W";
        String NOT_WORKING ="N";
        String BROKEN ="B";
    }
    @OneToMany
    @JoinColumn(name = "")
    public List<CronData> getCron() {
        return cron;
    }

    public LightLampData setCron(List<CronData> cron) {
        this.cron = cron;
        return this;
    }
}
