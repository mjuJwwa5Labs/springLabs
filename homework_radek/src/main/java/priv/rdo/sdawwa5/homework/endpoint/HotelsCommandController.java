package priv.rdo.sdawwa5.homework.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import priv.rdo.sdawwa5.homework.model.CreateHotelCommand;
import priv.rdo.sdawwa5.homework.model.Hotel;
import priv.rdo.sdawwa5.homework.service.HotelDomainService;

import java.net.URI;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("hotels")
class HotelsCommandController {
    private final HotelDomainService hotelDomainService;

    HotelsCommandController(HotelDomainService hotelDomainService) {
        this.hotelDomainService = hotelDomainService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateHotelCommand hotel) {
        Hotel save = hotelDomainService.createHotel(hotel.toHotel());

        return ResponseEntity.created(pathWithId(save.getId())).build();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void create(@PathVariable long id) {
        hotelDomainService.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody CreateHotelCommand hotel) {
        Hotel update = hotelDomainService.updateHotel(id, hotel.toHotel());

        return ResponseEntity.noContent().location(pathWithId(update.getId())).build();
    }

    private URI pathWithId(Object id) {
        return MvcUriComponentsBuilder
                .fromMethodName(HotelsSearchController.class, "findById", id)
                .buildAndExpand(id)
                .toUri();
    }
}
