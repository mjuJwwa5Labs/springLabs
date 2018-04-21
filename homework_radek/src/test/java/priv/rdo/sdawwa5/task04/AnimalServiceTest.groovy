package priv.rdo.sdawwa5.task04

import priv.rdo.sdawwa5.task02.Animal
import spock.lang.Specification

class AnimalServiceTest extends Specification {

    def "test buildAnimal"() {
        given: "an empty animal service"
            def animalService = new AnimalService()

        when:
            def animal = animalService.buildAnimal()

        then:
            animal.name == "faflun"
            animal.age == 666

    }
}
