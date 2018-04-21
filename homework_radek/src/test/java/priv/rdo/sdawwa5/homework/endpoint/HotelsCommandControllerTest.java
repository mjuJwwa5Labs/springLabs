package priv.rdo.sdawwa5.homework.endpoint;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import priv.rdo.sdawwa5.homework.IntegrationTestBase;
import priv.rdo.sdawwa5.homework.model.CreateHotelCommand;
import priv.rdo.sdawwa5.homework.model.Hotel;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

/**
 * są tylko przypadki pozytywne.
 * przydadzą się jeszcze negatywne (zły url, walidacja, etc, wszystko było na zajęciach)
 */
public class HotelsCommandControllerTest extends IntegrationTestBase {
    @Test
    public void shouldCreateNewHotel() {
        //@formatter:off
        givenForPost(new CreateHotelCommand("new hotel", "new hotel address"))
        .when()
            .post("hotels")
        .then()
            .log().ifValidationFails()
            .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .header("Location", containsString("/hotels/"))
        ;
        //@formatter:on
    }

    @Test
    public void shouldDeleteHotelById() {
        //given
        Hotel hotelToBeDeleted = hotelRepository.save(new Hotel("hotelToBeDeleted", "addr"));

        //@formatter:off
        givenForGet()
        .when()
            .delete("hotels/{id}", hotelToBeDeleted.getId())
        .then()
            .log().ifValidationFails()
            .assertThat()
                .statusCode(HttpStatus.NO_CONTENT.value())
        ;
        //@formatter:on
    }

    @Test
    public void shouldEditHotelById() {
        Hotel hotelToBeEdited = hotelRepository.save(new Hotel("hotelToBeEdited", "addr"));
        //@formatter:off
        givenForPost(new CreateHotelCommand("editedHotel", "addr"))
        .when()
            .put("hotels/{id}", hotelToBeEdited.getId())
        .then()
            .log().ifValidationFails()
            .assertThat()
                .statusCode(HttpStatus.NO_CONTENT.value())
        ;
        //@formatter:on

        //and then
        Hotel hotel = hotelRepository.findById(hotelToBeEdited.getId()).get();
        assertThat(hotel).isEqualToComparingOnlyGivenFields(new CreateHotelCommand("editedHotel", "addr"), "name", "address");
    }
}
