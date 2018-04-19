package com.mjuApps.springDemo.homework.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotels")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "hotelEntity", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<AddressEntity> addressList;

    @OneToMany(mappedBy = "hotelEntity", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<RoomEntity> roomList;

    public HotelEntity() {}

    public HotelEntity(String name, List<AddressEntity> addressList, List<RoomEntity> roomList) {
        this.name = name;
        this.addressList = addressList;
        this.roomList = roomList;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<AddressEntity> getAddressList() {
        return addressList;
    }

    public List<RoomEntity> getRoomList() {
        return roomList;
    }

    public void setAddressList(List<AddressEntity> addressList) {
        this.addressList = addressList;
    }

    public void setRoomList(List<RoomEntity> roomList) {
        this.roomList = roomList;
    }
}
