package priv.rdo.sdawwa5.homework;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import priv.rdo.sdawwa5.homework.repo.HotelRepository;
import priv.rdo.sdawwa5.homework.service.HotelSampleDataInitializer;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class IntegrationTestBase {
    @LocalServerPort
    private int port;

    @Autowired
    protected HotelSampleDataInitializer sampleDataInitializer;

    @Autowired
    protected HotelRepository hotelRepository;

    @Before
    public void setUp() {
        hotelRepository.deleteAll();
        sampleDataInitializer.init();
    }

    protected RequestSpecification givenForGet() {
        return RestAssured.given()
                .port(port)
                .log().ifValidationFails();
    }

    protected RequestSpecification givenForPost(Object body) {
        return givenForGet()
                .body(body)
                .contentType(MediaType.APPLICATION_JSON_VALUE);
    }
}
