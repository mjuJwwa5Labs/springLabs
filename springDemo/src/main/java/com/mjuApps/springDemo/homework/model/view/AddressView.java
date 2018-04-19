package com.mjuApps.springDemo.homework.model.view;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mjuApps.springDemo.homework.model.entity.HotelEntity;

/**
 * @author marek_j on 2018-04-18
 */
public class AddressView {

    private String addressName;
    private String street;
    private String streetNumber;
    private String city;
    private String zipCode;
    private String phoneNumber;

    @JsonBackReference
    private HotelEntity hotelEntity;

    public AddressView(String addressName, String street, String streetNumber, String city, String zipCode, String phoneNumber, HotelEntity hotelEntity) {
        this.addressName = addressName;
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.hotelEntity = hotelEntity;
    }

    public String getAddressName() {
        return addressName;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public HotelEntity getHotelEntity() {
        return hotelEntity;
    }
}
