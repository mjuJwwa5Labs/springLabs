package priv.rdo.sdawwa5.task09;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import priv.rdo.sdawwa5.security.command.CreateAccountCommand;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Task09ControllerTest {
    @LocalServerPort
    private int port;

    @Test
    public void shouldAddUserAndReturnStupidLocationHeader() {
        //given
        RequestSpecification given = given()
                .port(port)
                .auth().preemptive().basic("admin", "password")
                .body(new CreateAccountCommand("HackerMan", "h4ck3rP455w0rD"))
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .log().all();

        //when
        Response when = given
                .when()
                .post("task09");

        //then
        when.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .header("Location", containsString("stupid"))
        ;
    }

    @Test
    public void shouldFindAllUsers() {
        //@formatter:off
        given()
            .port(port)
            .auth().preemptive().basic("admin", "password")
            .log().all()
        .when()
            .get("task09")
        .then()
            .log().all()
            .assertThat()
                .statusCode(200)
                .body("username", hasItems("admin"))
        ;
        //@formatter:on
    }
}
