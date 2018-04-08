package com.mjuApps.springDemo.task05;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task05Controller {

    private final ApplicationContext applicationContext;

    public Task05Controller(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping("task05-0-0")
    void tester() {
        System.out.println();
    }
}
