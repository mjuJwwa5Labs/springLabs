package priv.rdo.sdawwa5.homework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    @JsonIgnore
    private Hotel hotel;

    private Long roomNumber;

    private Integer maxGuests;

    public Room(Hotel hotel, Long roomNumber, Integer maxGuests) {
        this.hotel = hotel;
        this.roomNumber = roomNumber;
        this.maxGuests = maxGuests;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
