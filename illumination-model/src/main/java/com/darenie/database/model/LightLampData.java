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


    @OneToOne
    @JoinColumn(name = "address_data_id")
    public AddressData getAddressData() {
        return addressData;
    }

    public void setAddressData(AddressData addressData) {
        this.addressData = addressData;
    }
}
