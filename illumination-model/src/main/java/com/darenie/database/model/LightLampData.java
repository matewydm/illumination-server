package com.darenie.database.model;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table (uniqueConstraints=
        @UniqueConstraint(columnNames={"light_lamp_module_id", "lamp_module_number"}))
@Entity
@AttributeOverrides(value = {
        @AttributeOverride(name = "id",column = @Column(name = "light_lamp_id")),
        @AttributeOverride(name = "name",column = @Column(name = "light_lamp_name")),
        @AttributeOverride(name = "description",column = @Column(name = "light_lamp_description")),
})
public class LightLampData extends AbstractData{

    private AddressData addressData;

    private String status;

    private List<TimeLineData> timeLineData;

    private LampModuleData lampModuleData;

    private Integer lampModuleNumber;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cron_data_id")
    public List<TimeLineData> getTimeLineData() {
        return timeLineData;
    }

    public void setTimeLineData(List<TimeLineData> timeLineData) {
        this.timeLineData = timeLineData;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "light_lamp_module_id")
    @NotNull
    public LampModuleData getLampModuleData() {
        return lampModuleData;
    }

    public void setLampModuleData(LampModuleData lampModuleData) {
        this.lampModuleData = lampModuleData;
    }

    @Column(name = "lamp_module_number")
    public Integer getLampModuleNumber() {
        return lampModuleNumber;
    }

    public void setLampModuleNumber(Integer lampModuleNumber) {
        this.lampModuleNumber = lampModuleNumber;
    }


    public interface Status{
        String WORKING ="W";
        String NOT_WORKING ="N";
        String BROKEN ="B";
    }
}
