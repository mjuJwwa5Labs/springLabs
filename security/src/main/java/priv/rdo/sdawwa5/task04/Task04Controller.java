package priv.rdo.sdawwa5.task04;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.rdo.sdawwa5.task02.Animal;

@RestController
public class Task04Controller {

    private final AnimalService animalService;

    public Task04Controller(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("task04")
    Animal task04() {
        return animalService.buildAnimal();
    }
}
