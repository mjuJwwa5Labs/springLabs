package com.mjuApps.springDemo.homework.controller;

import com.mjuApps.springDemo.homework.model.query.HotelQuery;
import com.mjuApps.springDemo.homework.model.view.HotelView;
import com.mjuApps.springDemo.homework.repository.RoomRepository;
import com.mjuApps.springDemo.homework.service.HotelService;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author marek_j on 2018-04-18
 */
@RestController
@RequestMapping("hotel/find")
public class HotelFindController {

//    private static final Logger LOG = LoggerFactory.getLogger(HotelController.class);
//    private HotelService hotelService;
//    private RoomRepository roomRepository;
//
//    public HotelFindController(HotelService hotelService, RoomRepository roomRepository) {
//        this.hotelService = hotelService;
//        this.roomRepository = roomRepository;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<HotelView>> findHotelByHotelQuery(@RequestParam(required = false) Integer minBeds,
//                                                                 @RequestParam(required = false) Integer maxBeds,
//                                                                 @RequestParam(required = false) Integer minExtraBeds,
//                                                                 @RequestParam(required = false) Integer maxExtraBeds,
//                                                                 @RequestParam(required = false) String city,
//                                                                 @RequestParam(required = false) String address) {
//        HotelQuery hotelQuery = new HotelQuery.HotelQueryBuilder()
//                                .withMinBedsWithNullOverwrite(minBeds)
//                                .withMaxBedsWithNullOverwrite(maxBeds)
//                                .withMinExtraBedsWithNullOverwrite(minExtraBeds)
//                                .withMaxExtraBedsWithNullOverwrite(maxExtraBeds)
//                                .withCity(city)
//                                .withAddress(address)
//                                .build();
//        List<HotelView> hotelViews = hotelService.findHotelByHotelQuery(hotelQuery);
//        return ResponseEntity.status(HttpStatus.OK).body(hotelViews);
//    }


}
