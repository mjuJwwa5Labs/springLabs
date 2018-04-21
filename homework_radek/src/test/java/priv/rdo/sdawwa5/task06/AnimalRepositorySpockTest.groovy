package priv.rdo.sdawwa5.task06

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import priv.rdo.sdawwa5.task02.Animal
import spock.lang.Specification

@DataJpaTest
class AnimalRepositorySpockTest extends Specification {

    @Autowired
    AnimalRepository animalRepository

    void setup() {
        animalRepository.save(new Animal("Faflun", 3))
        animalRepository.save(new Animal("Stefan", 4))
        animalRepository.save(new Animal("Stefan", 8))
        animalRepository.save(new Animal("Mściwór", 8))
    }

    def "should find only one Stefan with age of 8"() {
        when: ""
            def animals = animalRepository.findByNameAndAge("Stefan", 8)

        then: ""
            animals.size() == 1
            animals[0].name == "Stefan"
            animals[0].age == 8
    }

    def "should find top "() {
        when: ""
            def animals = animalRepository.findFirst3ByOrderByAgeDesc()

        then: ""
            animals.size() == 3
            animals[0].age == 8
            animals[1].age == 8
            animals[2].age == 4

    }
}
