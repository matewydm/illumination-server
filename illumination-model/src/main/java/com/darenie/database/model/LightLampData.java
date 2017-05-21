package com.darenie.database.model;

import javax.persistence.*;

@Table
@Entity
@AttributeOverrides(value = {
        @AttributeOverride(name = "id",column = @Column(name = "light_lamp_id")),
        @AttributeOverride(name = "name",column = @Column(name = "light_lamp_name")),
        @AttributeOverride(name = "description",column = @Column(name = "light_lamp_description")),
})
public class LightLampData extends AbstractData{



    private AddressData addressData;

    private String status;

//    private String type;

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
        String ON ="N";
        String OFF ="F";
    }
}
