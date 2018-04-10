package com.mjuApps.springDemo.homework.dao.uglyStatic;

import com.mjuApps.springDemo.homework.model.Address;
import com.mjuApps.springDemo.homework.model.Hotel;
import com.mjuApps.springDemo.homework.model.Room;
import com.mjuApps.springDemo.homework.model.RoomStatus;

import java.util.ArrayList;
import java.util.List;

public class TestHotel implements HotelGenerator {

    @Override
    public List<Room> buildRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room.RoomBuilder().withRoomNumber(101).withBeds(101).withExtraBeds(101).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(102).withBeds(102).withExtraBeds(102).withRoomStatus(RoomStatus.AVAILABLE).build());
        return rooms;
    }

    @Override
    public List<Address> buildAddressList() {
        Address grandHotelAddres = new Address.AddressBuilder()
                .withAddressName("Main Address")
                .withCity("Miasto Testów")
                .withStreet("Testerów")
                .withStreetNumber("49a / 50")
                .withZipCode("02-602")
                .withPhoneNumber("(22) 754 20 30")
                .build();
        List<Address> addresses = new ArrayList<>();
        addresses.add(grandHotelAddres);
        return addresses;
    }


    @Override
    public Hotel buildHotel() {
        return new Hotel("Testowy", buildAddressList(), buildRooms());
    }
}
