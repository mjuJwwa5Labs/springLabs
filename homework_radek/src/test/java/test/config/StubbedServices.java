package test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import priv.rdo.sdawwa5.task02.Animal;
import priv.rdo.sdawwa5.task04.AnimalService;

@Configuration
public class StubbedServices {

    @Bean
    @Primary
    public AnimalService stubbedAnimalService() {

        return new AnimalService() {
            @Override
            public Animal buildAnimal() {
                return new Animal("test", 5);
            }
        };
    }
}
