package priv.rdo.sdawwa5.homework.service;

import org.springframework.stereotype.Component;
import priv.rdo.sdawwa5.homework.model.Hotel;
import priv.rdo.sdawwa5.homework.model.Room;
import priv.rdo.sdawwa5.homework.repo.HotelRepository;
import priv.rdo.sdawwa5.homework.repo.RoomRepository;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

@Component
public class HotelSampleDataInitializer {
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    HotelSampleDataInitializer(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @PostConstruct
    public void init() {//do NOT do that in real code ; )
        Hotel sobieski = hotelRepository.save(new Hotel("Sobieski", "addr 1"));
        Hotel mariottWarszawa = hotelRepository.save(new Hotel("Mariott Warszawa", "addr 2"));
        Hotel radisonBlueWarszawa = hotelRepository.save(new Hotel("Radison Blue Warszawa", "addr 3"));

        Stream.of(
                new Room(sobieski, 1L, 2),
                new Room(sobieski, 2L, 4),
                new Room(sobieski, 3L, 6),
                new Room(mariottWarszawa, 1L, 4),
                new Room(mariottWarszawa, 2L, 6),
                new Room(mariottWarszawa, 3L, 8),
                new Room(radisonBlueWarszawa, 1L, 1),
                new Room(radisonBlueWarszawa, 2L, 3),
                new Room(radisonBlueWarszawa, 3L, 5)
        ).forEach(roomRepository::save);
    }
}
