package com.mjuApps.springDemo.tasks.task06;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
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
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

    @Test
    public void shouldAddAnimal() {
        //given
        RequestSpecification given = given()
                .port(port)
                .body(new Animal("Misha", 23))
                .header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .log().all();

        //when
        Response when = given
                .when()
                .post("task06");

        //then
        when.then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value());

        Animal animal = animalRepository.findByName("Misha").get(0);
        Assertions.assertThat(animal.getAge()).isEqualTo(23);
    }
}