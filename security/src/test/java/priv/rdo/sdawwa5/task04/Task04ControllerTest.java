package priv.rdo.sdawwa5.task04;

import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import priv.rdo.sdawwa5.SdaWwa5Application;
import test.config.StubbedServices;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SdaWwa5Application.class)
@ContextConfiguration(classes = StubbedServices.class)
public class Task04ControllerTest {

    @LocalServerPort
    private int port;

    @Test
    public void task04() {
        //@formatter:off
        given()
            .port(port)
            .log().all()
        .when()
            .get("task04")
        .then()
            .log().all()
            .assertThat()
                .statusCode(200)
                .body("name", containsString("test"));

    }
}
