package com.mjuApps.springDemo.task06;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author marek_j on 2018-04-14
 */
@Configuration
public class SampleDataInitializer {

    private final AnimalRepository animalRepository;

    public SampleDataInitializer(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @PostConstruct
    void init() {
        animalRepository.save(new Animal(null,"Piesek Leszek", 10));
        animalRepository.save(new Animal(null,"Test1", 1));
        animalRepository.save(new Animal(null,"Test5", 2));
        animalRepository.save(new Animal(null,"Test3", 3));
        animalRepository.save(new Animal(null,"Test2", 4));
    }
}
