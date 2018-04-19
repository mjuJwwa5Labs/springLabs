package com.mjuApps.springDemo.sampleData;

import com.mjuApps.springDemo.homework.model.entity.AddressEntity;
import com.mjuApps.springDemo.homework.model.entity.HotelEntity;
import com.mjuApps.springDemo.homework.model.entity.RoomEntity;
import com.mjuApps.springDemo.homework.model.entity.RoomStatus;
import com.mjuApps.springDemo.homework.repository.HotelRepository;
import com.mjuApps.springDemo.task06.Animal;
import com.mjuApps.springDemo.task06.AnimalRepository;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author marek_j on 2018-04-14
 */
@Configuration
public class SampleDataInitializer {

    private final AnimalRepository animalRepository;
    private final HotelRepository hotelRepository;

    public SampleDataInitializer(AnimalRepository animalRepository, HotelRepository hotelRepository) {
        this.animalRepository = animalRepository;
        this.hotelRepository = hotelRepository;
    }

    @PostConstruct
    void init() {
        buildAnimals();
        buildHotels();
    }

    private void buildAnimals() {
        animalRepository.save(new Animal("Piesek Leszek", 10));
        animalRepository.save(new Animal("Test1", 1));
        animalRepository.save(new Animal("Test5", 5));
        animalRepository.save(new Animal("Test6", 6));
        animalRepository.save(new Animal("Test3", 3));
        animalRepository.save(new Animal("Test2", 2));
    }

    private void buildHotels() {
        hotelRepository.save(buildGrandHotel());
        hotelRepository.save(buildHotelTransylwania());
        hotelRepository.save(buildHotelTestowy());
    }


    //HOTEL TRANSYLWANIA
    private HotelEntity buildHotelTransylwania() {
        HotelEntity hotelTransylwania = new HotelEntity("Hotel Transylwania", null, null);
        List<RoomEntity> hotelTransylwaniaRooms = buildHotelTransylwaniaRooms(hotelTransylwania);
        List<AddressEntity> hotelTransylwaniaAddressess = buildHotelTransylwaniaAddress(hotelTransylwania);
        hotelTransylwania.setAddressList(hotelTransylwaniaAddressess);
        hotelTransylwania.setRoomList(hotelTransylwaniaRooms);
        return hotelTransylwania;
    }

    private List<RoomEntity> buildHotelTransylwaniaRooms(HotelEntity hotelEntity) {
        List<RoomEntity> rooms = new ArrayList<>();
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(101).withBeds(4).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(103).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(104).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(105).withBeds(3).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(102).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(106).withBeds(3).withExtraBeds(1).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(107).withBeds(3).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(108).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(109).withBeds(3).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(110).withBeds(2).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(201).withBeds(3).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(202).withBeds(1).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(203).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(204).withBeds(2).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(205).withBeds(4).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(206).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(207).withBeds(3).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(208).withBeds(4).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(209).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(210).withBeds(4).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
        return rooms;
    }

    public List<AddressEntity> buildHotelTransylwaniaAddress(HotelEntity hotelEntity) {
        AddressEntity address = new AddressEntity.AddressBuilder()
                .withAddressName("Main Address")
                .withCity("Radom")
                .withStreet("Hrabiego Drakuli")
                .withStreetNumber("69a")
                .withZipCode("02-200")
                .withPhoneNumber("504 504 504")
                .withHotelEntity(hotelEntity)
                .build();
        List<AddressEntity> addresses = new ArrayList<>();
        addresses.add(address);
        return addresses;
    }


    //GRAND HOTEL
    private HotelEntity buildGrandHotel() {
        HotelEntity grandHotel = new HotelEntity("Grand Hotel", null, null);
        List<RoomEntity> grandHotelRooms = buildGrandHotelRooms(grandHotel);
        List<AddressEntity> grandHotelAddressess = buildGrandHotelAddress(grandHotel);
        grandHotel.setAddressList(grandHotelAddressess);
        grandHotel.setRoomList(grandHotelRooms);
        return grandHotel;
    }

    private List<RoomEntity> buildGrandHotelRooms(HotelEntity hotelEntity) {
        List<RoomEntity> rooms = new ArrayList<>();
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(102).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(104).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(105).withBeds(3).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(109).withBeds(3).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(110).withBeds(2).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(201).withBeds(3).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(202).withBeds(1).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(203).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(204).withBeds(2).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(206).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(207).withBeds(3).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(208).withBeds(4).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(210).withBeds(4).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(301).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(401).withBeds(2).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(404).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(409).withBeds(4).withExtraBeds(0).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(101).withBeds(4).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(103).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(106).withBeds(3).withExtraBeds(1).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(107).withBeds(3).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(108).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(205).withBeds(4).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(209).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(302).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(303).withBeds(1).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(304).withBeds(1).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(305).withBeds(2).withExtraBeds(1).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(402).withBeds(4).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(403).withBeds(2).withExtraBeds(2).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(405).withBeds(1).withExtraBeds(1).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(406).withBeds(3).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(407).withBeds(4).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(408).withBeds(3).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(410).withBeds(3).withExtraBeds(0).withRoomStatus(RoomStatus.OCCUPIED).withHotelEntity(hotelEntity).build());
        return rooms;
    }

    public List<AddressEntity> buildGrandHotelAddress(HotelEntity hotelEntity) {
        List<AddressEntity> addresses = new ArrayList<>();

        AddressEntity mainAddress = new AddressEntity.AddressBuilder()
                .withAddressName("Adres główny")
                .withCity("Warszawa")
                .withStreet("Nowy Świat")
                .withStreetNumber("49a / 50")
                .withZipCode("02-602")
                .withPhoneNumber("(22) 754 20 30")
                .withHotelEntity(hotelEntity)
                .build();

        AddressEntity postalAddress = new AddressEntity.AddressBuilder()
                .withAddressName("Adres pocztowy")
                .withCity("Warszawa")
                .withStreet("Stary Świat")
                .withStreetNumber("49a / 50")
                .withZipCode("02-602")
                .withPhoneNumber("(22) 754 20 30")
                .withHotelEntity(hotelEntity)
                .build();

        addresses.add(mainAddress);
        addresses.add(postalAddress);

        return addresses;
    }

    //HOTEL TESTOWY
    private HotelEntity buildHotelTestowy() {
        HotelEntity testowy = new HotelEntity("Testowy", null, null);
        List<RoomEntity> testowyRooms = buildHotelTestowyRooms(testowy);
        List<AddressEntity> testowyAddressess = buildHotelTestowyAddress(testowy);
        testowy.setAddressList(testowyAddressess);
        testowy.setRoomList(testowyRooms);
        return testowy;
    }

    private List<RoomEntity> buildHotelTestowyRooms(HotelEntity hotelEntity) {
        List<RoomEntity> rooms = new ArrayList<>();
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(1).withBeds(1).withExtraBeds(1).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(2).withBeds(2).withExtraBeds(2).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(3).withBeds(3).withExtraBeds(3).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
            rooms.add(new RoomEntity.RoomBuilder().withRoomNumber(100).withBeds(100).withExtraBeds(100).withRoomStatus(RoomStatus.AVAILABLE).withHotelEntity(hotelEntity).build());
        return rooms;
    }

    public List<AddressEntity> buildHotelTestowyAddress(HotelEntity hotelEntity) {
        AddressEntity address = new AddressEntity.AddressBuilder()
                .withAddressName("Main Address")
                .withCity("Miasto Testów")
                .withStreet("Testerów")
                .withStreetNumber("49a / 50")
                .withZipCode("02-602")
                .withPhoneNumber("(22) 754 20 30")
                .withHotelEntity(hotelEntity)
                .build();
        List<AddressEntity> addresses = new ArrayList<>();
        addresses.add(address);
        return addresses;
    }
}
