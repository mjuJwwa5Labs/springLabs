package com.mjuApps.springDemo.tasks.task01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstSpringController {

    @GetMapping("dupa")
    public String testFunc() {
        return "Dupa";
    }

}
