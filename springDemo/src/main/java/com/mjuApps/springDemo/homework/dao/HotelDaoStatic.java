package com.mjuApps.springDemo.homework.dao;

import com.mjuApps.springDemo.homework.dao.uglyStatic.HotelDB;
import com.mjuApps.springDemo.homework.model.Address;
import com.mjuApps.springDemo.homework.model.Hotel;
import com.mjuApps.springDemo.homework.model.Room;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HotelDaoStatic implements HotelDao {

    private HotelDB hotelDB = new HotelDB();

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        for (Hotel hotelFromDb : hotelDB.hotelList) {
            hotels.add(hotelFromDb);
        }
        return hotels;
    }

    @Override
    public List<Hotel> findHotelByName(String name) {
        List<Hotel> foundHotels = null;
        if (!StringUtils.isEmpty(name)) {
            foundHotels = hotelDB.hotelList.stream()
                    .filter(hotel -> hotel.getName().equals(name))
                    .collect(Collectors.toList());
        }
        return foundHotels;
    }

    //todo sprawdzic czemu dla danych testowych, gdzie jest tylko bedsLower/UpperLimit znajduje hotele
    @Override
    public List<Hotel> findHotelByRoomCapacity(Integer bedsLowerLimit, Integer bedsUpperLimit, Integer extraBedsLowerLimit, Integer extraBedsUpperLimit) {
        List<Hotel> hotelsList = new ArrayList<>();
        for (Hotel hotelFromDb : hotelDB.hotelList) {
            List<Room> roomList = hotelFromDb.getRoomList();
            Hotel foundHotel = null;
            for (Room room : roomList) {
                if (bedsLowerLimit!=null) {
                    if (bedsUpperLimit!=null) {
                        if (room.getBeds()>=bedsLowerLimit && room.getBeds()<=bedsUpperLimit) {
                            foundHotel = hotelFromDb;
                        }
                    }

                    if (bedsUpperLimit==null) {
                        if (room.getBeds()>=bedsLowerLimit) {
                            foundHotel = hotelFromDb;
                        }
                    }
                }

                if (bedsLowerLimit==null) {
                    if (bedsUpperLimit!=null) {
                        if (room.getBeds()<=bedsUpperLimit) {
                            foundHotel = hotelFromDb;
                        }
                    }
                }

                //---------
                if (extraBedsLowerLimit!=null) {
                    if (extraBedsUpperLimit!=null) {
                        if (room.getExtraBeds()>=extraBedsLowerLimit && room.getExtraBeds()<=extraBedsUpperLimit) {
                            foundHotel = hotelFromDb;
                        }
                    }

                    if (extraBedsUpperLimit==null) {
                        if (room.getExtraBeds()>=extraBedsLowerLimit) {
                            foundHotel = hotelFromDb;
                        }
                    }
                }
                if (extraBedsLowerLimit==null) {
                    if (extraBedsUpperLimit!=null) {
                        if (room.getExtraBeds()<=extraBedsUpperLimit) {
                            foundHotel = hotelFromDb;
                        }
                    }
                }
            }
            if (foundHotel!=null) {
                hotelsList.add(foundHotel);
            }
        }
        return hotelsList;
    }

    @Override
    public List<Hotel> findHotelByAddress(String address) {
        List<Hotel> hotelsList = new ArrayList<>();
        for (Hotel hotelFromDb : hotelDB.hotelList) {
            List<Address> addressList = hotelFromDb.getAddresList();
            Hotel foundHotel = null;
            for (Address addressOfHotel : addressList) {
                if (addressOfHotel.getAddressName().contains(address)) {
                    foundHotel = hotelFromDb;
                }
                if (addressOfHotel.getCity().contains(address)) {
                    foundHotel = hotelFromDb;
                }
                if (addressOfHotel.getStreet().contains(address)) {
                    foundHotel = hotelFromDb;
                }
                if (addressOfHotel.getStreetNumber().contains(address)) {
                    foundHotel = hotelFromDb;
                }
                if (addressOfHotel.getPhoneNumber().contains(address)) {
                    foundHotel = hotelFromDb;
                }
                if (addressOfHotel.getZipCode().contains(address)) {
                    foundHotel = hotelFromDb;
                }
            }
            if (foundHotel!=null) {
                hotelsList.add(foundHotel);
            }
        }
        return hotelsList;
    }
}
