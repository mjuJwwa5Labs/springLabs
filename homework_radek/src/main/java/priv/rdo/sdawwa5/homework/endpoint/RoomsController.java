package priv.rdo.sdawwa5.homework.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import priv.rdo.sdawwa5.homework.model.CreateRoomCommand;
import priv.rdo.sdawwa5.homework.model.Room;
import priv.rdo.sdawwa5.homework.service.RoomService;

import java.net.URI;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("hotels/{hotelId}/rooms")
class RoomsController {
    private final RoomService roomService;


    RoomsController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("{roomId}")
    public Room findByIds(@PathVariable long hotelId, @PathVariable long roomId) {
        return roomService.findByIds(hotelId, roomId);
    }

    @GetMapping
    public Room findByHotelIdAndRoomNumber(@PathVariable long hotelId, @RequestParam(defaultValue = "1") long roomNumber) {
        return roomService.findByRoomNumber(hotelId, roomNumber);
    }

    @PostMapping
    public ResponseEntity<Void> create(@PathVariable long hotelId, @RequestBody CreateRoomCommand newRoom) {
        Room room = roomService.saveRoom(hotelId, newRoom.toRoom());

        return ResponseEntity.created(pathWithId(hotelId, room.getId())).build();
    }

    @DeleteMapping("{roomId}")
    @ResponseStatus(NO_CONTENT)
    public void create(@PathVariable long hotelId, @PathVariable long roomId) {
        roomService.deleteByIds(hotelId, roomId);
    }

    private URI pathWithId(Object hotelId, Object roomId) {
        return MvcUriComponentsBuilder
                .fromMethodName(RoomsController.class, "findByIds", hotelId, roomId)
                .buildAndExpand(hotelId, roomId)
                .toUri();
    }
}
