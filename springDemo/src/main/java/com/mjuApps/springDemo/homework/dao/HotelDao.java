package com.mjuApps.springDemo.homework.dao;

import com.mjuApps.springDemo.homework.model.Hotel;

import java.util.List;

public interface HotelDao {

    List<Hotel> getAllHotels();

    List<Hotel> findHotelByName(String name);

}
