package priv.rdo.sdawwa5.task07;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Task07ControllerTest {

    @LocalServerPort
    private int port;

    @Test
    public void shouldThrowAnExceptionAndReturnValidErrorResponse() {
        //given
        RequestSpecification given = given()
                .port(port)
                .log().all();

        //when
        Response when = given
                .when()
                .get("task07");

        //then
        when.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.I_AM_A_TEAPOT.value())
                .body("message", containsString("my custom exception"))
        ;
    }

    @Test
    public void shouldAddAnimalAndReturnLocationHeader() {
        //given
        RequestSpecification given = given()
                .port(port)
                .body(new CreateAnimalCommand("Ivan Sędziwy", 78))
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .log().all();

        //when
        Response when = given
                .when()
                .post("task07");

        //then
        when.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .header("Location", containsString("localhost:" + port + "/task07"))
        ;
    }

    @Test
    public void shouldReturnValidationErrorIfAnimalsNameIsTooShort() {
        //given
        RequestSpecification given = given()
                .port(port)
                .body(new CreateAnimalCommand("Iv", 78))
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .log().all();

        //when
        Response when = given
                .when()
                .post("task07");

        //then
        when.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .body("validationErrors.message", hasItem("name too short, min 3 signs"))
                .body("validationErrors.rejectedValue", hasItem("Iv"))
        ;
    }

    @Test
    public void shouldReturnMultipleValidationErrorsIfNameAndAgeAreWrong() {
        //given
        RequestSpecification given = given()
                .port(port)
                .body(new CreateAnimalCommand("Iv", -3))
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .log().all();

        //when
        Response when = given
                .when()
                .post("task07");

        //then
        when.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .body("validationErrors.message", hasItems(
                        "name too short, min 3 signs",
                        "come on, animals cant have negative age"
                        )
                )
                .body("validationErrors.rejectedValue", hasItems("Iv", -3))
        ;
    }
}
