package com.mjuApps.springDemo.task06

import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

/**
 * @author marek_j on 2018-04-14
 */
class AnimalRepositorySpockTest extends Specification {

    @Autowired
    private AnimalRepository animalRepository;


    void setup() {
        animalRepository.save(new Animal("Fafik", 1));
        animalRepository.save(new Animal("Stefan", 2));
        animalRepository.save(new Animal("Leszek", 3));
        animalRepository.save(new Animal("Tomasz", 4));
    }

    def "FindByName"() {
    }

    def "FindByAge"() {
    }

    def "FindByNameOrAge"() {
    }

    def "FindFirst3ByOrderByNameDesc"() {
    }

    def "DeleteById"() {
    }
}
