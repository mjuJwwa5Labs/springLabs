package com.mjuApps.springDemo.tasks.task07;

import com.mjuApps.springDemo.tasks.task06.Animal;
import com.mjuApps.springDemo.tasks.task06.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author marek_j on 2018-04-15
 */
@Service
public class AnimalCommandService {

    private AnimalRepository animalRepository;

    public AnimalCommandService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal saveAnimal(Animal animal) {
        animalRepository.save(animal);
        return animal;
    }

    public Animal findById(Integer id) {
        Optional<Animal> animalOptional = animalRepository.findById(id);
        if (animalOptional.isPresent()) {
            return animalOptional.get();
        } else {
            return null;
        }
    }

}
