package com.mjuApps.springDemo.homework.service;

import com.mjuApps.springDemo.homework.dto.FindHotelDto;
import com.mjuApps.springDemo.homework.model.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotels();

    List<Hotel> findHotelByName(String hotelName);

    List<Hotel> findByHotelDto(FindHotelDto findHotelDto);
}
