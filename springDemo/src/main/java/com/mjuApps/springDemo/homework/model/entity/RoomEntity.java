package com.mjuApps.springDemo.homework.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "hotel_rooms")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_status")
    private RoomStatus status;

    @Column(name = "beds")
    private Integer beds;

    @Column(name = "extra_beds")
    private Integer extraBeds;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;

    private RoomEntity() {}

    public RoomEntity(Integer roomNumber, RoomStatus status, Integer beds, Integer extraBeds, HotelEntity hotelEntity) {
        this.roomNumber = roomNumber;
        this.status = status;
        this.beds = beds;
        this.extraBeds = extraBeds;
        this.hotelEntity = hotelEntity;
    }

    public RoomEntity(RoomBuilder roomBuilder) {
        this.roomNumber = roomBuilder.roomNumber;
        this.status = roomBuilder.status;
        this.beds = roomBuilder.beds;
        this.extraBeds = roomBuilder.extraBeds;
        this.hotelEntity = roomBuilder.hotelEntity;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public Integer getBeds() {
        return beds;
    }

    public Integer getExtraBeds() {
        return extraBeds;
    }

    public HotelEntity getHotelEntity() {return hotelEntity;}

    public void setHotelEntity(HotelEntity hotelEntity) {
        this.hotelEntity = hotelEntity;
    }

    public static class RoomBuilder {

        private Integer roomNumber;
        private RoomStatus status;
        private Integer beds;
        private Integer extraBeds;
        private HotelEntity hotelEntity;

        public RoomBuilder withRoomNumber(Integer roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public RoomBuilder withRoomStatus(RoomStatus status) {
            this.status = status;
            return this;
        }

        public RoomBuilder withBeds(Integer beds) {
            this.beds = beds;
            return this;
        }

        public RoomBuilder withExtraBeds(Integer extraBeds) {
            this.extraBeds = extraBeds;
            return this;
        }

        public RoomBuilder withHotelEntity(HotelEntity hotelEntity) {
            this.hotelEntity = hotelEntity;
            return this;
        }

        public RoomEntity build() {
            return new RoomEntity(this);
        }
    }
}
