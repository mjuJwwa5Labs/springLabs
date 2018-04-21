package priv.rdo.sdawwa5.task07;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import priv.rdo.sdawwa5.task02.Animal;
import priv.rdo.sdawwa5.task06.AnimalRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("task07")
public class Task07Controller {
    private final AnimalRepository animalRepository;

    public Task07Controller(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    String throwing() {
        throw new CustomException();
    }

    @PostMapping
    ResponseEntity<Void> addAnimal(@Valid @RequestBody CreateAnimalCommand command) {
        Animal animal = animalRepository.save(command.toAnimal());

        return ResponseEntity.created(pathWithId(animal.getId())).build();
    }

    @GetMapping("{id}")
    ResponseEntity<Animal> findById(@PathVariable long id) {
        Optional<Animal> animal = animalRepository.findById(id);
        if (animal.isPresent()){
            return ResponseEntity.ok(animal.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private URI pathWithId(Object id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id.toString())
                .toUri();
    }

}
