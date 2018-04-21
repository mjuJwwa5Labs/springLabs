package priv.rdo.sdawwa5.homework.endpoint;

import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import priv.rdo.sdawwa5.homework.IntegrationTestBase;
import priv.rdo.sdawwa5.homework.model.CreateRoomCommand;
import priv.rdo.sdawwa5.homework.model.Hotel;
import priv.rdo.sdawwa5.homework.model.Room;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

public class RoomsControllerTest extends IntegrationTestBase {
    @Test
    public void shouldFindOneRoomByHotelIdAndRoomNumber() {
        Hotel sobieski = hotelRepository.findByNameContaining("Sobieski").get(0);
        Room sobieskiRoomNumberOne = sobieski.getRooms().get(0);

        //@formatter:off
        givenForGet()
                .param("roomNumber", sobieskiRoomNumberOne.getRoomNumber())
        .when()
            .get("hotels/{id}/rooms", sobieski.getId())
        .then()
            .log().ifValidationFails()
            .assertThat()
                .statusCode(200)
                .body("id", is(sobieskiRoomNumberOne.getId().intValue()))
        ;
        //@formatter:on
    }

    @Test
    public void shouldFindOneRoomByHotelIdAndRoomId() {
        Hotel sobieski = hotelRepository.findByNameContaining("Sobieski").get(0);
        Room sobieskiRoomNumberOne = sobieski.getRooms().get(0);

        //@formatter:off
        Response response = givenForGet()
        .when()
            .get("hotels/{id}/rooms/{roomId}", sobieski.getId(), sobieskiRoomNumberOne.getId());
        response
        .then()
            .log().ifValidationFails()
            .assertThat()
                .statusCode(200)
                .body("id", CoreMatchers.is(sobieskiRoomNumberOne.getId().intValue()))
        ;
        //@formatter:on
    }

    @Test
    public void shouldCreateNewRoomAndAddItToHotel() {
        Hotel sobieski = hotelRepository.findByNameContaining("Sobieski").get(0);
        assertThat(sobieski.getRooms()).hasSize(3);

        //@formatter:off
        givenForPost(new CreateRoomCommand(6L, 6))
        .when()
            .post("hotels/{id}/rooms/", sobieski.getId())
        .then()
            .log().ifValidationFails()
            .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .header("Location", containsString("/hotels/" + sobieski.getId() + "/rooms/"))
        ;
        //@formatter:on

        assertThat(hotelRepository.findById(sobieski.getId()).get().getRooms()).hasSize(4);
    }
}
