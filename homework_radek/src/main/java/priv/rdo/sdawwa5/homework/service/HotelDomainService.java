package priv.rdo.sdawwa5.homework.service;

import org.springframework.stereotype.Service;
import priv.rdo.sdawwa5.homework.model.Hotel;
import priv.rdo.sdawwa5.homework.repo.HotelRepository;

@Service
public class HotelDomainService {
    private final HotelRepository hotelRepository;
    private final HotelSearchService hotelSearchService;

    public HotelDomainService(HotelRepository hotelRepository, HotelSearchService hotelSearchService) {
        this.hotelRepository = hotelRepository;
        this.hotelSearchService = hotelSearchService;
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteById(long id) {
        Hotel found = hotelSearchService.findById(id);
        hotelRepository.deleteById(found.getId());
    }

    public Hotel updateHotel(long id, Hotel newHotelData) {
        Hotel found = hotelSearchService.findById(id);
        found.setAddress(newHotelData.getAddress());
        found.setName(newHotelData.getName());

        return hotelRepository.save(found);
    }
}
