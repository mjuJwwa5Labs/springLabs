package com.mjuApps.springDemo.task07;

import com.mjuApps.springDemo.task06.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

/**
 * @author marek_j on 2018-04-15
 */
@RestController
@RequestMapping("task07")
public class Task07Controller {

    private AnimalCommandService animalCommandService;

    public Task07Controller(AnimalCommandService animalCommandService) {
        this.animalCommandService = animalCommandService;
    }

    @GetMapping
    public String showCustomError() {
        throw new CustomException();
    }

    @PostMapping
    public ResponseEntity<?> createAnimalCommand(@Valid @RequestBody CreateAnimalCommand createAnimalCommand) {
        Animal animal = new Animal(createAnimalCommand.getName(),createAnimalCommand.getAge());
        Animal savedAnimal = animalCommandService.saveAnimal(animal);
        CreateAnimalCommand saveAnimalCommand = new CreateAnimalCommand(savedAnimal.getName(),savedAnimal.getAge());
        return ResponseEntity.status(HttpStatus.CREATED).location(pathWithId(animal.getId())).body(saveAnimalCommand);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") String id) {
        Integer idInteger = Integer.valueOf(id);
        Animal animal = animalCommandService.findById(idInteger);
        CreateAnimalCommand saveAnimalCommand = new CreateAnimalCommand(animal.getName(),animal.getAge());
        return ResponseEntity.status(HttpStatus.CREATED).location(pathWithId(animal.getId())).body(saveAnimalCommand);
    }

    private URI pathWithId(Object id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id.toString())
                .toUri();
    }

}
