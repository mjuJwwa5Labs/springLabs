package priv.rdo.sdawwa5.task06;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import priv.rdo.sdawwa5.task02.Animal;

import java.util.List;
import java.util.Optional;

@RestController
public class Task06Controller {
    private final AnimalRepository animalRepository;

    public Task06Controller(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("task06")
    List<Animal> task06() {
        return animalRepository.findAll();
    }

    @PostMapping(value = "task06")
    @ResponseStatus(HttpStatus.CREATED)
    void addAnimal(@RequestBody Animal animal) {
        animalRepository.save(animal);
    }

    @GetMapping("task06byName")
    List<Animal> byName(@RequestParam String name) {
        return animalRepository.findByName(name);
    }

    @GetMapping("task06byAge")
    List<Animal> byName(@RequestParam int age) {
        return animalRepository.findByAge(age);
    }

    @GetMapping("task06byNameAndAge")
    List<Animal> byName(@RequestParam String name, @RequestParam int age) {
        return animalRepository.findByNameAndAge(name, age);
    }

    @GetMapping("task06top3")
    List<Animal> byName() {
        return animalRepository.findFirst3ByOrderByAgeDesc();
    }

    @DeleteMapping("task06/{id}")
    ResponseEntity<Void> deleteById(@PathVariable long id) {
        if (animalRepository.findById(id).isPresent()){
            animalRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("task06/{id}")
    ResponseEntity<Animal> findById(@PathVariable long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        if (animal.isPresent()){
            return ResponseEntity.ok(animal.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "task06multiple")
    @ResponseStatus(HttpStatus.CREATED)
    void addAnimals(@RequestBody List<Animal> animals) {
        animalRepository.saveAll(animals);
    }
}
