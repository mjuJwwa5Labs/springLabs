package priv.rdo.sdawwa5.homework.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import priv.rdo.sdawwa5.homework.model.Hotel;
import priv.rdo.sdawwa5.homework.service.HotelSearchService;

import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelsSearchController {

    private final HotelSearchService hotelSearchService;

    public HotelsSearchController(HotelSearchService hotelSearchService) {
        this.hotelSearchService = hotelSearchService;
    }

    @GetMapping
    public List<Hotel> listAllHotels() {
        return hotelSearchService.findAll();
    }

    @GetMapping("{id}")
    public Hotel findById(@PathVariable long id) {
        return hotelSearchService.findById(id);
    }

    @GetMapping("search/room-params")
    public ResponseEntity<List<Hotel>> findWithMinPeople(@RequestParam Integer minPeople) {
        List<Hotel> found = hotelSearchService.findWithMinimumPeopleInRoom(minPeople);
        if (found == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(found);
    }

    @GetMapping("search/hotel-params")
    public ResponseEntity<List<Hotel>> findWithName(@RequestParam String name) {
        List<Hotel> found = hotelSearchService.findByNameContaining(name);
        if (found == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(found);
    }
}
