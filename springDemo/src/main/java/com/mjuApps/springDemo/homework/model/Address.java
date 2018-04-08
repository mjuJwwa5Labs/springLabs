package com.mjuApps.springDemo.homework.model;

public class Address {

    private String addressName;
    private String street;
    private String streetNumber;
    private String city;
    private String zipCode;
    private String phoneNumber;

    public Address() {}

    public Address(AddressBuilder addressBuilder) {
        this.addressName = addressBuilder.addressName;
        this.street = addressBuilder.street;
        this.streetNumber = addressBuilder.streetNumber;
        this.city = addressBuilder.city;
        this.zipCode = addressBuilder.zipCode;
        this.phoneNumber = addressBuilder.phoneNumber;
    }

    //getters
    public String getAddressName() { return addressName;  }
    public String getStreet() { return street; }
    public String getStreetNumber() { return streetNumber; }
    public String getCity() { return city; }
    public String getZipCode() { return zipCode; }
    public String getPhoneNumber() { return phoneNumber; }

    //builder
    public static class AddressBuilder {
        private String addressName;
        private String street;
        private String streetNumber;
        private String city;
        private String zipCode;
        private String phoneNumber;

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

        public Address build() {
            return new Address(this);
        }

    }

}
