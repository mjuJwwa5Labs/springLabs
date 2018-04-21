package priv.rdo.sdawwa5.task02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
public class Task02Controller {
    private static final Logger LOG = LoggerFactory.getLogger(Task02Controller.class);

    @GetMapping(value = "task02animals")
    List<Animal> getAnimals() {
        return Arrays.asList(
                new Animal("Mściwór", 86),
                new Animal("Faflun", 3)
        );
    }

    @GetMapping(value = "task02", produces = APPLICATION_JSON_VALUE)
    Animal getAnimal() {
        return new Animal("Mściwór", 86);
    }

    @GetMapping(value = "task02xml", produces = APPLICATION_XML_VALUE)
    Animal getAnimal2() {
        return new Animal("Mściwór", 86);
    }

    @GetMapping(value = "task02accept")
    Animal getAnimal3(@RequestHeader("Accept") String accept,
                      @RequestHeader HttpHeaders headers) {
        LOG.info("accept header: {}", accept);
        headers.forEach(
                (name, value) -> LOG.warn("header name: {}, header value: {}", name, value)
        );
        return new Animal("Mściwór", 86);
    }
}
