package com.mjuApps.springDemo.homework.dao.uglyStatic;

import com.mjuApps.springDemo.homework.model.Address;
import com.mjuApps.springDemo.homework.model.Hotel;
import com.mjuApps.springDemo.homework.model.Room;
import com.mjuApps.springDemo.homework.model.RoomStatus;

import java.util.ArrayList;
import java.util.List;

public class GrandHotel implements HotelGenerator {

    @Override
    public List<Room> buildRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room.RoomBuilder().withRoomNumber(101).withBeds(4).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(102).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(103).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(104).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(105).withBeds(3).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(106).withBeds(3).withExtraBeds(1).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(107).withBeds(3).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(108).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(109).withBeds(3).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(110).withBeds(2).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(201).withBeds(3).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(202).withBeds(1).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(203).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(204).withBeds(2).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(205).withBeds(4).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(206).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(207).withBeds(3).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(208).withBeds(4).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(209).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(210).withBeds(4).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(301).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(302).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(303).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(304).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(305).withBeds(2).withExtraBeds(1).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(401).withBeds(2).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(402).withBeds(4).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(403).withBeds(2).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(404).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(405).withBeds(1).withExtraBeds(1).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(406).withBeds(3).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(407).withBeds(4).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(408).withBeds(3).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(409).withBeds(4).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(410).withBeds(3).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        return rooms;
    }

    @Override
    public List<Address> buildAddressList() {
        Address grandHotelAddres = new Address.AddressBuilder()
                .withAddressName("Main Address")
                .withCity("Warszawa")
                .withStreet("Nowy Świat")
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
        return new Hotel("Grand Hotel", buildAddressList(), buildRooms());
    }
}
