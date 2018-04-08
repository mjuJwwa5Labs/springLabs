package com.mjuApps.springDemo.task02.controller;

import com.mjuApps.springDemo.task02.model.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
public class Task02Controller {

    @GetMapping("task02-0")
    public Animal doGetAnimal() {
        return new Animal("Piesek Leszek", 10);
    }

    @GetMapping(value = "task02-1", produces = APPLICATION_XML_VALUE)
    public Animal doGetAnimalAsXml() {
        return new Animal("Piesek Leszek", 10);
    }

}
