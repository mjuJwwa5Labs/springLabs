package com.mjuApps.springDemo.homework.service;

import com.mjuApps.springDemo.homework.dao.HotelDao;
import com.mjuApps.springDemo.homework.dao.HotelDaoStatic;
import com.mjuApps.springDemo.homework.dto.HotelDto;
import com.mjuApps.springDemo.homework.model.Address;
import com.mjuApps.springDemo.homework.model.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HotelServiceStaticList implements HotelService {

    private static final Logger LOG = LoggerFactory.getLogger(HotelServiceStaticList.class);
    private HotelDao hotelDao = new HotelDaoStatic();

    @Override
    public List<Hotel> getAllHotels() {
        return hotelDao.getAllHotels();
    }

    @Override
    public List<Hotel> findHotelByName(String hotelName) {
        return hotelDao.findHotelByName(hotelName);
    }

    //todo przerobić tę metodę tak, aby porozbijać jakoś te paskudne ify
    @Override
    public List<Hotel> findByHotelDto(HotelDto hotelDto) {
        List<Hotel> hotels = hotelDao.getAllHotels();
        Set<Hotel> foundHotelsSet = new HashSet<>();
        String expectedName = hotelDto.getName();
        String expectedAddress = hotelDto.getAddress();

        for (Hotel hotel : hotels) {
            if (!StringUtils.isEmpty(hotelDto.getAddress())) {
                for (Address hotelAddress : hotel.getAddresList()) {
                    if (hotelAddress.getAddressName().contains(expectedAddress)) {
                        foundHotelsSet.add(hotel);
                    }
                    if (hotelAddress.getCity().contains(expectedAddress)) {
                        foundHotelsSet.add(hotel);
                    }
                    if (hotelAddress.getStreet().contains(expectedAddress)) {
                        foundHotelsSet.add(hotel);
                    }
                    if (hotelAddress.getStreetNumber().contains(expectedAddress)) {
                        foundHotelsSet.add(hotel);
                    }
                    if (hotelAddress.getPhoneNumber().contains(expectedAddress)) {
                        foundHotelsSet.add(hotel);
                    }
                    if (hotelAddress.getZipCode().contains(expectedAddress)) {
                        foundHotelsSet.add(hotel);
                    }
                }
            }

            if (!StringUtils.isEmpty(hotelDto.getName())) {
                if (hotel.getName().contains(expectedName)) {
                    foundHotelsSet.add(hotel);
                }
            }
        }
        return foundHotelsSet.stream().collect(Collectors.toList());
    }


}
