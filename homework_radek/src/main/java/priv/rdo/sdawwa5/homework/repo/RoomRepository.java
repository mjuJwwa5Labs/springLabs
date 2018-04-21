package priv.rdo.sdawwa5.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.rdo.sdawwa5.homework.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomByHotel_idAndRoomNumber(long hotelId, long roomNumber);
}
