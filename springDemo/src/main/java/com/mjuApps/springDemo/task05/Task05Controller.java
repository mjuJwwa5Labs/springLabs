package com.mjuApps.springDemo.task05;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task05Controller {

    private final ApplicationContext applicationContext;
    private final NotManagedBySpring notManagedBySpring;

    public Task05Controller(ApplicationContext applicationContext, NotManagedBySpring notManagedBySpring) {
        this.applicationContext = applicationContext;
        this.notManagedBySpring = notManagedBySpring;
    }

    @GetMapping("task05-0-0")
    void tester() {
        System.out.println();
    }

    @GetMapping("task05-0-1")
    NotManagedBySpring checkNotManagedBySpring() {
        return notManagedBySpring;
    }
}
