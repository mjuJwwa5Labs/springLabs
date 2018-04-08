package com.mjuApps.springDemo.homework.dao;

import com.mjuApps.springDemo.homework.dao.uglyStatic.HotelDB;
import com.mjuApps.springDemo.homework.model.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HotelDaoStatic implements HotelDao {

    private HotelDB hotelDB = new HotelDB();

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        for (Hotel hotelFromDb : hotelDB.hotelList) {
            hotels.add(hotelFromDb);
        }
        return hotels;
    }

    @Override
    public List<Hotel> findHotelByName(String name) {
        List<Hotel> foundHotels = hotelDB.hotelList.stream()
                .filter(hotel -> hotel.getName().equals(name))
                .collect(Collectors.toList());
        return foundHotels;
    }
}
