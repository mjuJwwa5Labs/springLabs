package priv.rdo.sdawwa5.task06;

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
import org.springframework.test.context.junit4.SpringRunner;
import priv.rdo.sdawwa5.task02.Animal;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Task06ControllerTest {
    @LocalServerPort
    int port;

    @Autowired
    private AnimalRepository animalRepository;

    Animal andrzejTestowy;

    @Before
    public void setUp() throws Exception {
        andrzejTestowy = animalRepository.save(new Animal("Andrzej", 45));
    }

    @Test
    public void shouldFindFaflunById() {
        //@formatter:off
        given()
            .pathParam("id", andrzejTestowy.getId())
            .port(port)
            .log().all()
        .when()
            .get("task06/{id}")
        .then()
            .log().all()
            .assertThat()
                .statusCode(200)
                .body("name", containsString(andrzejTestowy.getName()))
        ;
        //@formatter:on
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
                .statusCode(HttpStatus.CREATED.value())
        ;

        Animal animal = animalRepository.findByName("Misha").get(0);
        Assertions.assertThat(animal.getAge()).isEqualTo(23);
    }
}
