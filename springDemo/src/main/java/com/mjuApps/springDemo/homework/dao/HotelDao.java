package com.mjuApps.springDemo.homework.dao;

import com.mjuApps.springDemo.homework.model.Hotel;

import java.util.List;
import java.util.Set;

public interface HotelDao {

    List<Hotel> getAllHotels();

    List<Hotel> findHotelByName(String name);

    List<Hotel> findHotelByAddress(String address);

    List<Hotel> findHotelByRoomCapacity(Integer bedsLowerLimit, Integer bedsUpperLimit, Integer extraBedsLowerLimit, Integer extraBedstUpperLimit);

}
