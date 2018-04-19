package com.mjuApps.springDemo.homework.controller;

import com.mjuApps.springDemo.homework.model.query.HotelQuery;
import com.mjuApps.springDemo.homework.repository.RoomRepository;
import com.mjuApps.springDemo.homework.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author marek_j on 2018-04-18
 */
@RestController
@RequestMapping("hotel/find")
public class HotelFindController {

    private static final Logger LOG = LoggerFactory.getLogger(HotelController.class);
    private HotelService hotelService;
    private RoomRepository roomRepository;

    public HotelFindController(HotelService hotelService, RoomRepository roomRepository) {
        this.hotelService = hotelService;
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public ResponseEntity<HotelQuery> findHotelByHotelQuery() {
        return ResponseEntity.status(HttpStatus.OK).body(new HotelQuery());
    }

}
