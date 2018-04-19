package com.mjuApps.springDemo.homework.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address_name")
    private String addressName;

    @Column(name = "street")
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="hotel_id")
    private HotelEntity hotelEntity;

    public AddressEntity() {}

    public AddressEntity(String addressName, String street, String streetNumber, String city, String zipCode, String phoneNumber, HotelEntity hotelEntity) {
        this.addressName = addressName;
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.hotelEntity = hotelEntity;
    }

    public AddressEntity(AddressBuilder addressBuilder) {
        this.addressName = addressBuilder.addressName;
        this.street = addressBuilder.street;
        this.streetNumber = addressBuilder.streetNumber;
        this.city = addressBuilder.city;
        this.zipCode = addressBuilder.zipCode;
        this.phoneNumber = addressBuilder.phoneNumber;
    }

    //getters
    public Integer getId() {return id;}

    public String getAddressName() {return addressName;}

    public String getStreet() {return street;}

    public String getStreetNumber() {return streetNumber;}

    public String getCity() {return city;}

    public String getZipCode() {return zipCode;}

    public String getPhoneNumber() {return phoneNumber;}

    //settters
    public void setHotelEntity(HotelEntity hotelEntity) {this.hotelEntity = hotelEntity;}

    //builder
    public static class AddressBuilder {

        private String addressName;
        private String street;
        private String streetNumber;
        private String city;
        private String zipCode;
        private String phoneNumber;
        private HotelEntity hotelEntity;

        public AddressBuilder withAddressName(String addressName) {
            this.addressName = addressName;
            return this;
        }

        public AddressBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder withStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public AddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder withZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public AddressBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public AddressBuilder withHotelEntity(HotelEntity hotelEntity) {
            this.hotelEntity = hotelEntity;
            return this;
        }

        public AddressEntity build() {
            return new AddressEntity(this);
        }

    }
}
