package com.mjuApps.springDemo.homework.controller;

import com.mjuApps.springDemo.homework.model.view.HotelView;
import com.mjuApps.springDemo.homework.model.view.RoomView;
import com.mjuApps.springDemo.homework.repository.RoomRepository;
import com.mjuApps.springDemo.homework.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelController {

    private static final Logger LOG = LoggerFactory.getLogger(HotelController.class);
    private HotelService hotelService;
    private RoomRepository roomRepository;

    public HotelController(HotelService hotelService, RoomRepository roomRepository) {
        this.hotelService = hotelService;
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public ResponseEntity<List<HotelView>> getAllHotels() {
        List<HotelView> hotelViewList = hotelService.getAllHotels();
        if (hotelViewList==null ||hotelViewList.size()==0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(hotelViewList);
    }

    @GetMapping("{hotelId}")
    public ResponseEntity<HotelView> getHotelById(@PathVariable Integer hotelId) {
        HotelView hotelView = hotelService.getHotelById(hotelId);
        if (hotelView==null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).location(pathWithId(hotelId,null)).body(hotelView);
    }

    @GetMapping("{hotelId}/room/{roomNumber}")
    public ResponseEntity<RoomView> getRoomByRoomNumberAndHotelId(@PathVariable Integer hotelId, @PathVariable Integer roomNumber) {
        RoomView roomView = hotelService.getRoomByHotelIdAndRoomNumber(hotelId,roomNumber);
        if (roomView==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).location(pathWithId(hotelId,roomNumber)).body(roomView);
    }




    private URI pathWithId(Object hotelId, Object roomNumber) {
        StringBuilder pathString = new StringBuilder();

        if (hotelId!=null) {
            pathString.append("/{hotelId}");
        }

        if (roomNumber!=null) {
            pathString.append("/room/{roomNumber}");
        }

        return ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(pathString.toString()).toUri();
    }
}
