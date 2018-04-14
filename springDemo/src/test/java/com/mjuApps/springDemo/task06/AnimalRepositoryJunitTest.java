package com.mjuApps.springDemo.task06;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author marek_j on 2018-04-14
 */
//@SpringBootTest   - jezeli chcę użyć innej instancji H2 do testów, bez konieczności wczytywania konfiguracji
//                  - to muszę użyć tej adnotacji
//                  - http://www.baeldung.com/spring-testing-separate-data-source
@DataJpaTest
@RunWith(SpringRunner.class)
public class AnimalRepositoryJunitTest {

    @Autowired
    private AnimalRepository animalRepository;

    @Before
    public void setup() {
        animalRepository.save(new Animal("Fafik", 1));
        animalRepository.save(new Animal("Stefan", 2));
        animalRepository.save(new Animal("Leszek", 3));
        animalRepository.save(new Animal("Tomasz", 4));
    }


    @Test
    public void shouldFindFafikByName() {
        //given-when
        List<Animal> animalList = animalRepository.findByName("Fafik");

        //then
        Assertions.assertThat(animalList).hasSize(1);
        Assertions.assertThat(animalList.get(0))
                .isEqualToIgnoringGivenFields(new Animal("Fafik", 1), "id");
    }

    @Test
    public void findByAge() {
        //given-when
        List<Animal> animalList = animalRepository.findByAge(4);
        Assertions.assertThat(animalList).hasSize(1);
        Assertions.assertThat(animalList).allMatch(
                animal -> animal.getAge().equals(4)
        );
    }

    @Test
    public void findByNameOrAge() {
        //given-when
        List<Animal> animalList = animalRepository.findByNameOrAge("Fafik", 4);

        Assertions.assertThat(animalList).hasSize(2);
        Assertions.assertThat(animalList.get(0))
                .isEqualToIgnoringGivenFields(new Animal("Fafik", 4), "id");
    }


    @Test
    public void findFirst3ByOrderByNameDesc() {
    }

    @Test
    public void deleteById() {
    }
}