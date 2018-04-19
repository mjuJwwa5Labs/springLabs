package com.mjuApps.springDemo.homework.model.view;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mjuApps.springDemo.homework.model.entity.RoomStatus;

/**
 * @author marek_j on 2018-04-18
 */
public class RoomView {

    private Integer roomNumber;
    private RoomStatus status;
    private Integer beds;
    private Integer extraBeds;

    @JsonBackReference
    private HotelView hotelView;

    public RoomView(Integer roomNumber, RoomStatus status, Integer beds, Integer extraBeds, HotelView hotelView) {
        this.roomNumber = roomNumber;
        this.status = status;
        this.beds = beds;
        this.extraBeds = extraBeds;
        this.hotelView = hotelView;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public Integer getBeds() {
        return beds;
    }

    public Integer getExtraBeds() {
        return extraBeds;
    }

    public HotelView getHotelView() {
        return hotelView;
    }
}
