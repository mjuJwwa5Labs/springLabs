package com.mjuApps.springDemo.homework.controller;

import com.mjuApps.springDemo.homework.dto.HotelDto;
import com.mjuApps.springDemo.homework.model.Hotel;
import com.mjuApps.springDemo.homework.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@RestController
public class HotelController {

    private static final Logger LOG = LoggerFactory.getLogger(HotelController.class);
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(value = "hotel/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping(value = "hotel/find")
    public List<Hotel> getHotelByName(@RequestParam(defaultValue = "") String name,
                                      @RequestParam(defaultValue = "") String address) {

        HotelDto hotelDto = new HotelDto(name,address);
        return hotelService.findByHotelDto(hotelDto);
    }


}
