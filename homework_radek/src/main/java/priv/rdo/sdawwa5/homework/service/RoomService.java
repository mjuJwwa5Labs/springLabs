package priv.rdo.sdawwa5.homework.service;

import org.springframework.stereotype.Service;
import priv.rdo.sdawwa5.homework.exception.EntityNotFoundException;
import priv.rdo.sdawwa5.homework.model.Hotel;
import priv.rdo.sdawwa5.homework.model.Room;
import priv.rdo.sdawwa5.homework.repo.RoomRepository;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HotelSearchService hotelSearchService;

    public RoomService(RoomRepository roomRepository, HotelSearchService hotelSearchService) {
        this.roomRepository = roomRepository;
        this.hotelSearchService = hotelSearchService;
    }

    public Room findByIds(long hotelId, long roomId) {
        hotelSearchService.findById(hotelId); //to check if hotel even exists
        return roomRepository.findById(roomId).orElseThrow(EntityNotFoundException::new);
    }

    public Room findByRoomNumber(long hotelId, long roomNumber) {
        return roomRepository.findRoomByHotel_idAndRoomNumber(hotelId, roomNumber);
    }

    public Room saveRoom(long hotelId, Room room) {
        Hotel hotel = hotelSearchService.findById(hotelId);
        room.setHotel(hotel);
        return roomRepository.save(room);
    }

    public void deleteByIds(long hotelId, long roomId) {
        hotelSearchService.findById(hotelId); //to check if hotel even exists
        roomRepository.deleteById(roomId);
    }
}
