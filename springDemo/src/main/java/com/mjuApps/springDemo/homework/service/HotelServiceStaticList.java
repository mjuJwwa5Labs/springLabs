package com.mjuApps.springDemo.homework.service;

import com.mjuApps.springDemo.homework.dao.HotelDao;
import com.mjuApps.springDemo.homework.dao.HotelDaoStatic;
import com.mjuApps.springDemo.homework.dto.FindHotelDto;
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

    //todo - przerobiłem DAO, tak aby wyciągałao wszystkie hotele, które spełniają kryteria adresu
    @Override
    public List<Hotel> findByHotelDto(FindHotelDto findHotelDto) {
        List<Hotel> hotelByName = null;
        List<Hotel> hotelsByAddress = null;
        List<Hotel> hotelsByRoomCapacity = null;

        String expectedName = findHotelDto.getName();
        if (expectedName!=null && !StringUtils.isEmpty(expectedName)) {
            hotelByName = hotelDao.findHotelByName(findHotelDto.getName());
        }

        String expectedAddress = findHotelDto.getAddress();
        if (expectedAddress!=null && !StringUtils.isEmpty(expectedAddress)) {
            hotelsByAddress = hotelDao.findHotelByAddress(findHotelDto.getAddress());
        }

        Integer bedsLowerLimit = findHotelDto.getBedsLowerLimit();
        Integer bedsUpperLimit = findHotelDto.getBedsUpperLimit();
        Integer extraBedsLowerLimit = findHotelDto.getExtraBedsLowerLimit();
        Integer extraBedsUpperLimit = findHotelDto.getExtraBedsUpperLimit();
        if (bedsLowerLimit!=null || bedsUpperLimit!=null || extraBedsLowerLimit!=null || extraBedsUpperLimit!=null) {
            hotelsByRoomCapacity = hotelDao.findHotelByRoomCapacity(findHotelDto.getBedsLowerLimit(),
                    findHotelDto.getBedsUpperLimit(),
                    findHotelDto.getExtraBedsLowerLimit(),
                    findHotelDto.getBedsUpperLimit());
        }


        Set<Hotel> hotelSet = new HashSet<>();
        if (hotelByName!=null) {
            hotelSet.addAll(hotelByName);
        }

        if (hotelsByAddress!=null) {
            hotelSet.addAll(hotelsByAddress);
        }

        if (hotelsByRoomCapacity!=null) {
            hotelSet.addAll(hotelsByRoomCapacity);
        }

        return hotelSet.stream().collect(Collectors.toList());
    }
}
