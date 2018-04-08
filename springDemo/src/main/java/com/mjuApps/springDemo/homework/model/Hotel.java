package com.mjuApps.springDemo.homework.model;

import java.util.List;

public class Hotel {

    private String name;
    private List<Address> addresList;
    private List<Room> roomList;

    public Hotel(String name, List<Address> addresList, List<Room> roomList) {
        this.name = name;
        this.addresList = addresList;
        this.roomList = roomList;
    }

    public String getName() {
        return name;
    }

    public List<Address> getAddresList() {
        return addresList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }
}
