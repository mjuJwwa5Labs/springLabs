package com.mjuApps.springDemo.homework.model.view;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author marek_j on 2018-04-18
 */
public class HotelView {

    private Integer id;
    private String name;

    @JsonManagedReference
    private List<AddressView> addressViewList;

    @JsonManagedReference
    private List<RoomView> roomViewList;

    @JsonCreator
    public HotelView(@JsonProperty("id") Integer id,
                     @JsonProperty("name") String name,
                     @JsonProperty("addressList") List<AddressView> addressViewList,
                     @JsonProperty("rooms") List<RoomView> roomViewList) {
        this.id = id;
        this.name = name;
        this.addressViewList = addressViewList;
        this.roomViewList = roomViewList;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonProperty("addressList")
    public List<AddressView> getAddressViewList() {
        return addressViewList;
    }

    @JsonProperty("rooms")
    public List<RoomView> getRoomViewList() {
        return roomViewList;
    }

    public void setAddressViewList(List<AddressView> addressViewList) {
        this.addressViewList = addressViewList;
    }

    public void setRoomViewList(List<RoomView> roomViewList) {
        this.roomViewList = roomViewList;
    }
}
