package com.mjuApps.springDemo.task02.controller;

import com.mjuApps.springDemo.task02.model.Animal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task02Controller {

    @GetMapping("task02")
    public Animal doGetAnimal() {
        return new Animal("Piesek Leszek", 10);
    }

}
