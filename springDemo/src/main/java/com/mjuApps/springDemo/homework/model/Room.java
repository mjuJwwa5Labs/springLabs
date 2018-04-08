package com.mjuApps.springDemo.homework.model;

public class Room {

    private Integer roomNumber;
    private RoomStatus status;
    private Integer beds;
    private Integer bedsAdditional;

    public Room() {}

    public Room(RoomBuilder roomBuilder) {
        this.roomNumber = roomBuilder.roomNumber;
        this.status = roomBuilder.status;
        this.beds = roomBuilder.beds;
        this.bedsAdditional = roomBuilder.bedsAdditional;
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

    public Integer getBedsAdditional() {
        return bedsAdditional;
    }

    public static class RoomBuilder {

        private Integer roomNumber;
        private RoomStatus status;
        private Integer beds;
        private Integer bedsAdditional;

        public RoomBuilder withRoomNumber(Integer number) {
            this.roomNumber = number;
            return this;
        }

        public RoomBuilder withRoomStatus(RoomStatus roomStatus) {
            this.status = roomStatus;
            return this;
        }

        public RoomBuilder withBedsQty(Integer quantity) {
            this.beds = quantity;
            return this;
        }

        public RoomBuilder withBedsAdditionalQty(Integer quantity) {
            this.bedsAdditional = quantity;
            return this;
        }

        public Room build() {
            return new Room(this);
        }
    }
}
