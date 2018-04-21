package com.mjuApps.springDemo.tasks.task06;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @ApiOperation(value = "doaje nowego zwierza", response = Animal.class, responseContainer="List", tags = "ANIMALS")
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

    @GetMapping(value = "/animal/find/top3")
    public ResponseEntity<?> findFirst3ByNameOrderByNameDesc() {
        List<Animal> animals = animalRepository.findFirst3ByOrderByNameDesc();
        return ResponseEntity.ok().body(animals);
    }

    @GetMapping(value = "/animal/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") String id) {
        Integer idInteger = Integer.valueOf(id);
        Optional<Animal> animalOptional = animalRepository.findById(idInteger);
        if (animalOptional.isPresent()) {
            return ResponseEntity.ok().body(animalOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "/animal/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") String id) {
        Integer idInteger = Integer.valueOf(id);

        if (animalRepository.findById(idInteger).isPresent()) {
            animalRepository.deleteById(idInteger);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "/animal/list")
    public ResponseEntity<?> addNewAnimal(@RequestBody List<Animal> animalList) {
        animalRepository.saveAll(animalList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
