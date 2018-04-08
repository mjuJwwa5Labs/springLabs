package com.mjuApps.springDemo.task04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private static final Logger LOG = LoggerFactory.getLogger(AnimalService.class);

    public Animal buildAnimal(String name, Integer age) {
        Animal animal = new Animal(name,age);
        LOG.info("Animal created in AnimalService = " + animal.toString());
        return animal;
    }


}
