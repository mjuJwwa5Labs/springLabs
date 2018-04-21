package com.mjuApps.springDemo.tasks.task04;

import com.mjuApps.springDemo.SpringDemoApplication;
import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.containsString;

/**
 * @author marek_j on 2018-04-14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringDemoApplication.class)
public class Task04ControllerTest {

    @LocalServerPort
    private Integer port;

    @Test
    public void task04() {
        //@formatter:off
        RestAssured
                .given()
                    .port(port)
                    .log().all()
                .when()
                    .get("task04")
                .then()
                    .log().all()
                    .assertThat()
                    .statusCode(200)
                    .body("name", containsString("Leszek"));

        }
    }