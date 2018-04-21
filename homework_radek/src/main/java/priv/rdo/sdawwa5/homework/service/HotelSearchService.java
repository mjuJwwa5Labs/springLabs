package priv.rdo.sdawwa5.homework.service;

import org.springframework.stereotype.Service;
import priv.rdo.sdawwa5.homework.exception.EntityNotFoundException;
import priv.rdo.sdawwa5.homework.model.Hotel;
import priv.rdo.sdawwa5.homework.repo.HotelRepository;

import java.util.List;

@Service
public class HotelSearchService {
    private final HotelRepository hotelRepository;

    public HotelSearchService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public Hotel findById(long id) {
        return hotelRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Hotel> findWithMinimumPeopleInRoom(int minPeople) {
        return hotelRepository.findWithMinPeopleCount(minPeople);
    }

    public List<Hotel> findByNameContaining(String name) {
        return hotelRepository.findByNameContaining(name);
    }
}
