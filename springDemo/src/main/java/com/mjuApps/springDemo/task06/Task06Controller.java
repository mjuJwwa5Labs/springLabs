package com.mjuApps.springDemo.task06;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author marek_j on 2018-04-14
 */
@RestController
public class Task06Controller {

    private AnimalRepository animalRepository;

    public Task06Controller(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @PostMapping(value = "/animal")
    public ResponseEntity<?> addNewAnimal(@RequestBody Animal animal) {
        animalRepository.save(animal);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/animal")
    public ResponseEntity<?> getAllAnimals() {
        List<Animal> animals = animalRepository.findAll();
        return ResponseEntity.ok().body(animals);
    }

    @GetMapping(value = "/animal/find/name")
    public ResponseEntity<?> findByName(@RequestParam String name) {
        List<Animal> animals = animalRepository.findByName(name);
        return ResponseEntity.ok().body(animals);
    }

    @GetMapping(value = "/animal/find/age")
    public ResponseEntity<?> findByAge(@RequestParam String age) {
        Integer ageInteger = Integer.valueOf(age);
        List<Animal> animals = animalRepository.findByAge(ageInteger);
        return ResponseEntity.ok().body(animals);
    }

    @GetMapping(value = "/animal/find/nameAndAge")
    public ResponseEntity<?> findByNameAndAge(@RequestParam String name,
                                              @RequestParam String age) {
        Integer ageInteger = Integer.valueOf(age);
        List<Animal> animals = animalRepository.findByNameOrAge(name,ageInteger);
        return ResponseEntity.ok().body(animals);
    }

    @GetMapping(value = "/animal/find/withLimit3")
    public ResponseEntity<?> findFirst3ByNameOrderByNameDesc() {
        List<Animal> animals = animalRepository.findFirst3ByOrderByNameDesc();
        return ResponseEntity.ok().body(animals);
    }

}
