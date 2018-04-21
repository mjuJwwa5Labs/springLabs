package com.mjuApps.springDemo.tasks.task02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
class Task02Controller {

    //todo live template - dodać sobie to do log
    private static final Logger LOG = LoggerFactory.getLogger(Task02Controller.class);

    @GetMapping("task02-0")
    public Animal doGetAnimal() {
        return new Animal("Piesek Leszek", 10);
    }

    @GetMapping(value = "task02-1", produces = MediaType.APPLICATION_XML_VALUE)
    public Animal doGetAnimalAsXml() {
        return new Animal("Piesek Leszek", 10);
    }

    @GetMapping(value = "task02-3-1")
    public void doGetAnimalAcceptHeader(@RequestHeader("Accept") String accept) {
        LOG.info("RequestHeader(\"Accept\") = " + accept);
    }

    @GetMapping(value = "task02-3-2")
    public void doGetAnimalHeaders(@RequestHeader HttpHeaders headers) {
        //todo przerobic to na foreach
        for (Map.Entry<String, List<String>> header : headers.entrySet()) {
            LOG.info("@RequestHeader(\"" + header.getKey() + "\"), Values: ");
            for (String headerValue : header.getValue()) {
                LOG.info(headerValue);
            }
        }
    }

    @GetMapping(value = "task02-3-3/all",  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Animal> doGetAllAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Piesek Leszek",10));
        animals.add(new Animal("Żabka Mała",2));
        return animals;
    }

}
