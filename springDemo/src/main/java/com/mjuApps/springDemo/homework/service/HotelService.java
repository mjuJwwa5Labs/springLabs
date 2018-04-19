package com.mjuApps.springDemo.homework.service;

import com.mjuApps.springDemo.homework.mapper.HotelMapper;
import com.mjuApps.springDemo.homework.model.entity.HotelEntity;
import com.mjuApps.springDemo.homework.model.entity.RoomEntity;
import com.mjuApps.springDemo.homework.model.view.HotelView;
import com.mjuApps.springDemo.homework.model.view.RoomView;
import com.mjuApps.springDemo.homework.repository.HotelRepository;
import com.mjuApps.springDemo.homework.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author marek_j on 2018-04-18
 */

@Service
public class HotelService {

    private HotelRepository hotelRepository;
    private RoomRepository roomRepository;
    private HotelMapper hotelMapper;

    public HotelService(HotelRepository hotelRepository, RoomRepository roomRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.hotelMapper = hotelMapper;
    }

    public List<HotelView> getAllHotels() {
        List<HotelEntity> hotelEntities = hotelRepository.findAll();
        List<HotelView> hotelViews =  hotelMapper.mapHotelEntitiesListToHotelViewList(hotelEntities);
        return hotelViews;
    }

    public HotelView getHotelById(Integer id) {
        Optional<HotelEntity> hotelEntityOptional = hotelRepository.findById(id);
        if (hotelEntityOptional.isPresent()) {
            return hotelMapper.mapHotelEntityToHotelView(hotelEntityOptional.get());
        }
        return null;
    }

    public RoomView getRoomByHotelIdAndRoomNumber(Integer hotelId, Integer roomNumber) {
        Optional<RoomEntity> roomEntityOptional = roomRepository.findByIdAndRoomNumber(hotelId,roomNumber);
        if (roomEntityOptional.isPresent()) {
            RoomEntity roomEntity = roomEntityOptional.get();
            HotelEntity hotelEntity = roomEntity.getHotelEntity();
            HotelView hotelView = hotelMapper.mapHotelEntityToHotelView(hotelEntity);
            return new RoomView(roomEntity.getRoomNumber(),roomEntity.getStatus(),roomEntity.getBeds(),roomEntity.getExtraBeds(),hotelView);
        }
        return null;
    }
}
