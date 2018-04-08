package com.mjuApps.springDemo.homework.dao.uglyStatic;

import com.mjuApps.springDemo.homework.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelDB {

    public static List<Hotel> hotelList;
    private List<HotelGenerator> hotelGenerators;

    public HotelDB() {

        if (hotelList==null) {
            hotelList = new ArrayList<>();
        }

        hotelGenerators = new ArrayList<>();
        hotelGenerators.add(new GrandHotel());
        hotelGenerators.add(new HotelTransylwania());

        for (HotelGenerator hotelGenerator : hotelGenerators) {
            hotelList.add(hotelGenerator.buildHotel());
        }
    }

}
