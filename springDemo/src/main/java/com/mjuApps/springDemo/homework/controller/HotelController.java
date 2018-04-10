package com.mjuApps.springDemo.homework.controller;

import com.mjuApps.springDemo.homework.dto.FindHotelDto;
import com.mjuApps.springDemo.homework.model.Hotel;
import com.mjuApps.springDemo.homework.service.HotelService;
import com.mjuApps.springDemo.homework.validator.Errors;
import com.mjuApps.springDemo.homework.validator.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    private static final Logger LOG = LoggerFactory.getLogger(HotelController.class);
    private HotelService hotelService;
    private Validator bedsNumberValidator;


    public HotelController(HotelService hotelService,
                           @Qualifier("bedsNumberValidator") Validator bedsNumberValidator) {
        this.hotelService = hotelService;
        this.bedsNumberValidator = bedsNumberValidator;
    }

    @GetMapping(value = "hotel/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping(value = "hotel/find")
    public ResponseEntity<?> findHotelByReqParams(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String address,
                                                  @RequestParam(defaultValue = "") String bedsLowerLimit, @RequestParam(defaultValue = "") String bedsUpperLimit,
                                                  @RequestParam(defaultValue = "") String extraBedsLowerLimit, @RequestParam(defaultValue = "") String extraBedsUpperLimit) {
        FindHotelDto findHotelDto = null;
        Errors errors = new Errors();
        try {
            findHotelDto = new FindHotelDto.FindHotelDtoBuilder()
                                        .withName(name).withAddress(address)
                                        .withBedsLowerLimitAsString(bedsLowerLimit).withBedsUpperLimitAsString(bedsUpperLimit)
                                        .withExtraBedsLowerLimitAsString(extraBedsLowerLimit).withExtraBedsUpperLimitAsString(extraBedsUpperLimit)
                                        .build();
            bedsNumberValidator.validate(findHotelDto,errors);
        } catch (NumberFormatException ex) {
            errors.addError("ProblemWithJsonData",ex.getMessage());
        }

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        } else {
            return ResponseEntity.ok().body(hotelService.findByHotelDto(findHotelDto));
//            return ResponseEntity.ok().body(findHotelDto);
        }
    }
}
