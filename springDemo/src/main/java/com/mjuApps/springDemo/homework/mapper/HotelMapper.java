package com.mjuApps.springDemo.homework.mapper;

import com.mjuApps.springDemo.homework.model.entity.AddressEntity;
import com.mjuApps.springDemo.homework.model.entity.HotelEntity;
import com.mjuApps.springDemo.homework.model.entity.RoomEntity;
import com.mjuApps.springDemo.homework.model.view.AddressView;
import com.mjuApps.springDemo.homework.model.view.HotelView;
import com.mjuApps.springDemo.homework.model.view.RoomView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author marek_j on 2018-04-18
 */
@Component
public class HotelMapper {

    public HotelView mapHotelEntityToHotelView(HotelEntity hotelEntity) {
        List<RoomEntity> roomEntities = hotelEntity.getRoomList();
        List<AddressEntity> addressEntities = hotelEntity.getAddressList();
        HotelView hotelView = new HotelView(hotelEntity.getId(),hotelEntity.getName(),null,null);

        List<RoomView> roomViews = new ArrayList<>();
        for (RoomEntity roomEntity : roomEntities) {
            roomViews.add(new RoomView(roomEntity.getRoomNumber(),roomEntity.getStatus(),roomEntity.getBeds(),roomEntity.getExtraBeds(),hotelView));
        }

        List<AddressView> addressViews = new ArrayList<>();
        for (AddressEntity addressEntity : addressEntities) {
            addressViews.add(new AddressView(addressEntity.getAddressName(),addressEntity.getStreet(),
                    addressEntity.getStreetNumber(),addressEntity.getCity(),addressEntity.getZipCode(),
                    addressEntity.getPhoneNumber(),hotelEntity));
        }
        hotelView.setAddressViewList(addressViews);
        hotelView.setRoomViewList(roomViews);
        return hotelView;
    }

    public List<HotelView> mapHotelEntitiesListToHotelViewList(List<HotelEntity> hotelEntities) {
        List<HotelView> hotelViews = new ArrayList<>();
        for (HotelEntity hotelEntity : hotelEntities) {
            hotelViews.add(mapHotelEntityToHotelView(hotelEntity));
        }
        return hotelViews;
    }



}
