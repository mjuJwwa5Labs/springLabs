package com.mjuApps.springDemo.task06;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

/**
 * @author marek_j on 2018-04-14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Rollback
@Transactional
public class Task06ControllerTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private AnimalRepository animalRepository;

    @Before
    public void setUp() {
        animalRepository.save(new Animal("Fafik", 1));
    }

    @Test
    public void shouldGetStatus200WhenFindAnimalWithIdWithExistingAnimal() {
        //@formatter:off
        Integer animalId = 1;

        RestAssured
                .given()
                    .pathParam("id", animalId)
                    .port(port)
                    .log().all()
                .when()
                    .get("/animal/{id}")
                .then()
                    .log().all()
                    .assertThat()
                    .statusCode(200)
                    .body("name", containsString("Fafik"));
    }
}