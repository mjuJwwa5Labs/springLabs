package com.mjuApps.springDemo.tasks.task04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(AnimalServiceTest.class);
    AnimalService animalService;

    @Before
    public void setup() {
        animalService = new AnimalService();
    }

    @Test
    public void shouldCreateNewAnimal() {
        String name = "Piesek Leszek";
        Integer age = 10;
        Animal actualAnimal = animalService.buildAnimal(name, age);

        Assert.assertEquals("Name should be " + name, name, actualAnimal.getName());
        Assert.assertEquals("Age should be " + age, age, actualAnimal.getAge());
    }

}