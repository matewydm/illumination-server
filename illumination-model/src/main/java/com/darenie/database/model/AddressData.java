package com.darenie.database.model;


import javax.persistence.*;

@Table
@Entity
@AttributeOverrides(value = {
        @AttributeOverride(name = "id", column = @Column(name = "address_data_id")),
        @AttributeOverride(name = "name", column = @Column(name = "address_data_name")),
        @AttributeOverride(name = "description", column = @Column(name = "address_data_description"))
})
public class AddressData extends AbstractData {


    private Double latitude;

    private Double longitude;

    private String country;

    private String city;

    private String street;

    private String Status;


    @Column
    public Double getLatitude() {
        return latitude;
    }

    @Column(length = 3)
    public String getCountry() {
        return country;
    }

    @Column
    public String getCity() {
        return city;
    }

    @Column
    public String getStreet() {
        return street;
    }

    @Column(length = 1)
    public String getStatus() {
        return Status;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public void setStreet(String street) {
        this.street = street;
    }


    public void setStatus(String status) {
        Status = status;
    }

    public interface Status {
        String BROKEN = "B";
        String NOT_BROKEN = "W";
    }
}
