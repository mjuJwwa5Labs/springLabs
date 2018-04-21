package priv.rdo.sdawwa5.homework.endpoint;

import org.junit.Test;
import priv.rdo.sdawwa5.homework.IntegrationTestBase;
import priv.rdo.sdawwa5.homework.model.Hotel;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

/**
 * są tylko przypadki pozytywne.
 * przydadzą się jeszcze negatywne (zły url, walidacja, etc, wszystko było na zajęciach)
 */
public class HotelsSearchControllerTest extends IntegrationTestBase {

    @Test
    public void shouldListAllHotels() {
        //@formatter:off
        givenForGet()
        .when()
            .get("hotels")
        .then()
            .log().ifValidationFails()
            .assertThat()
                .statusCode(200)
                .body("name", hasItems("Sobieski", "Mariott Warszawa", "Radison Blue Warszawa"));
        //@formatter:on
    }

    @Test
    public void shouldFindSobieskiById() {
        Hotel sobieski = hotelRepository.findByNameContaining("Sobieski").get(0);

        //@formatter:off
        givenForGet()
        .when()
            .get("hotels/{id}", sobieski.getId())
        .then()
            .log().ifValidationFails()
            .assertThat()
                .statusCode(200)
                .body("name", containsString("Sobieski"))
                .body("rooms.maxGuests", hasItems(2, 4, 6))
        ;
        //@formatter:on
    }

    @Test
    public void shouldFind2HotelsWithMin6People() {
        //@formatter:off
        givenForGet()
                .param("minPeople", 6)
        .when()
            .get("hotels/search/room-params")
        .then()
            .log().ifValidationFails()
            .assertThat()
                .statusCode(200)
                .body("size()", is(2))
                .body("name", hasItems("Sobieski", "Mariott Warszawa"))
        ;
        //@formatter:on
    }

    @Test
    public void shouldFindOneSobieski() {
        //@formatter:off
        givenForGet()
                .param("name", "Sobieski")
        .when()
            .get("hotels/search/hotel-params")
        .then()
            .log().ifValidationFails()
            .assertThat()
                .statusCode(200)
                .body("size()", is(1))
                .body("name", hasItems("Sobieski"))
        ;
        //@formatter:on
    }
}
