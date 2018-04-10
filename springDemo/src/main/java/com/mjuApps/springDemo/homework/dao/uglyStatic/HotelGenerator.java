package com.mjuApps.springDemo.homework.dao.uglyStatic;

import com.mjuApps.springDemo.homework.model.Address;
import com.mjuApps.springDemo.homework.model.Hotel;
import com.mjuApps.springDemo.homework.model.Room;

import java.util.List;

public interface HotelGenerator {

    List<Room> buildRooms();
    List<Address> buildAddressList();
    Hotel buildHotel();

}
