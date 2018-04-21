package priv.rdo.sdawwa5.task06;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import priv.rdo.sdawwa5.task02.Animal;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnimalRepositoryJUnitTest {
    @Autowired
    private AnimalRepository animalRepository;

    @Before
    public void setUp() throws Exception {
        animalRepository.save(new Animal("Faflun", 3));
        animalRepository.save(new Animal("Stefan", 4));
        animalRepository.save(new Animal("Stefan", 8));
        animalRepository.save(new Animal("Mściwór", 8));
    }

    @Test
    public void shouldFindOneFaflunByName() {
        //when
        List<Animal> animals = animalRepository.findByName("Faflun");

        //then
        assertThat(animals).hasSize(1);
        assertThat(animals.get(0)).isEqualToIgnoringGivenFields(
                new Animal("Faflun", 3), "id"
        );
    }

    @Test
    public void shouldFindTwoAnimalsByAgeOf8() {
        //when
        List<Animal> animals = animalRepository.findByAge(8);

        //then
        assertThat(animals).hasSize(2);
        assertThat(animals).allMatch(
                animal -> animal.getAge() == 8
        );
    }
}
