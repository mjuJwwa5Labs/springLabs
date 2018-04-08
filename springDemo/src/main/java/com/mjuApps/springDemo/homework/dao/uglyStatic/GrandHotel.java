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
        rooms.add(new Room.RoomBuilder().withRoomNumber(101).withBedsQty(4).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(102).withBedsQty(1).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(103).withBedsQty(1).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(104).withBedsQty(1).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(105).withBedsQty(3).withBedsAdditionalQty(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(106).withBedsQty(3).withBedsAdditionalQty(1).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(107).withBedsQty(3).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(108).withBedsQty(1).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(109).withBedsQty(3).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(110).withBedsQty(2).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(201).withBedsQty(3).withBedsAdditionalQty(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(202).withBedsQty(1).withBedsAdditionalQty(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(203).withBedsQty(1).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(204).withBedsQty(2).withBedsAdditionalQty(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(205).withBedsQty(4).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(206).withBedsQty(1).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(207).withBedsQty(3).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(208).withBedsQty(4).withBedsAdditionalQty(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(209).withBedsQty(1).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(210).withBedsQty(4).withBedsAdditionalQty(1).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(301).withBedsQty(1).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(302).withBedsQty(1).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(303).withBedsQty(1).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(304).withBedsQty(1).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(305).withBedsQty(2).withBedsAdditionalQty(1).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(401).withBedsQty(2).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(402).withBedsQty(4).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(403).withBedsQty(2).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(404).withBedsQty(1).withBedsAdditionalQty(2).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(405).withBedsQty(1).withBedsAdditionalQty(1).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(406).withBedsQty(3).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(407).withBedsQty(4).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(408).withBedsQty(3).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(409).withBedsQty(4).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.AVAILABLE).build());
        rooms.add(new Room.RoomBuilder().withRoomNumber(410).withBedsQty(3).withBedsAdditionalQty(0).withRoomStatus(RoomStatus.OCCUPIED).build());
        return rooms;
    }

    @Override
    public List<Address> buildAdressess() {
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
        return new Hotel("Grand Hotel", buildAdressess(), buildRooms());
    }
}
