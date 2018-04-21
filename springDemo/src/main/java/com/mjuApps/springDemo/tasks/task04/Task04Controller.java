package com.mjuApps.springDemo.tasks.task04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Task04Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Task04Controller.class);

    private AnimalService animalService;

    public Task04Controller(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("task04")
    public Animal Task04AnimalWithService() {
        Animal animal = animalService.buildAnimal("Piesek Leszek", 10);
        LOG.info("Animal in Task04Controller.Task04AnimalWithService" + animal.toString());
        return animal;
    }


}
