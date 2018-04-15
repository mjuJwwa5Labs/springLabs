package com.mjuApps.springDemo.task07;

import com.mjuApps.springDemo.task06.Animal;
import com.mjuApps.springDemo.task06.AnimalRepository;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author marek_j on 2018-04-15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Rollback
@Transactional
public class Task07ControllerTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private AnimalRepository animalRepository;

    @Before
    public void setUp() {
        animalRepository.save(new Animal("Fafik", 1));
    }

    @Test
    public void shouldCreateAnimalAndReturnCreatedResponse() {
        //given
        RequestSpecification given = given()
                .port(port)
                .body(new CreateAnimalCommand("Misha", 23))
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .log().all();
        //when
        Response when = given
                .when()
                .post("/task07");
        when.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .header("Location", containsString("localhost:" + port + "/task07"));
    }

    @Test
    public void shouldFailWhenAnimalNameIsNull() {
        //given
        RequestSpecification given = given()
                .port(port)
                .body(new CreateAnimalCommand(null, 23))
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .log().all();
        //when
        Response when = given
                .when()
                .post("/task07");
        when.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .header("Location", nullValue())
                .body("errors.defaultMessage",hasItem("name can't be null"));
    }
}