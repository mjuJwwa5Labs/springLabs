package priv.rdo.sdawwa5.homework.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CreateRoomCommand {
    private Long roomNumber;
    private Integer maxGuests;

    public Room toRoom() {
        return new Room(null, roomNumber, maxGuests);
    }
}
