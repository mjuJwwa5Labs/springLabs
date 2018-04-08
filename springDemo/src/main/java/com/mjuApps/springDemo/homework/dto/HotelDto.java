package com.mjuApps.springDemo.homework.dto;

public class HotelDto {

    private String name;
    private String address;

    public HotelDto(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}
