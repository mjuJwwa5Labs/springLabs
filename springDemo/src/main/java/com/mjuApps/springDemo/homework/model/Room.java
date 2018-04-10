package com.mjuApps.springDemo.homework.model;

public class Room {

    private Integer roomNumber;
    private RoomStatus status;
    private Integer beds;
    private Integer extraBeds;

    public Room() {}

    public Room(RoomBuilder roomBuilder) {
        this.roomNumber = roomBuilder.roomNumber;
        this.status = roomBuilder.roomStatus;
        this.beds = roomBuilder.beds;
        this.extraBeds = roomBuilder.extraBeds;
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

    public static class RoomBuilder {

        private Integer roomNumber;
        private RoomStatus roomStatus;
        private Integer beds;
        private Integer extraBeds;

        public RoomBuilder withRoomNumber(Integer roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public RoomBuilder withRoomStatus(RoomStatus roomStatus) {
            this.roomStatus = roomStatus;
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

        public Room build() {
            return new Room(this);
        }
    }
}
