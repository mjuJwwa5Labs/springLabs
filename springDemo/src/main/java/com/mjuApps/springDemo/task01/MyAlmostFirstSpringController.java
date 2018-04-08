package com.mjuApps.springDemo.task01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAlmostFirstSpringController {

    @GetMapping("hello")
    public String hello(@RequestParam(value = "name", defaultValue = "anonimusie:-)") String name) {
        return "Cześć " + name;
    }

}
