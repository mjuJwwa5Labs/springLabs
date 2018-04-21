package priv.rdo.sdawwa5.homework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import priv.rdo.sdawwa5.homework.model.Hotel;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("select distinct hotel from Hotel hotel join hotel.rooms room where room.maxGuests >= ?1")
    List<Hotel> findWithMinPeopleCount(int minPeople);

    List<Hotel> findByNameContaining(String name);
}
