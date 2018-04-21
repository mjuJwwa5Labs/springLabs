package test.config;

import com.mjuApps.springDemo.tasks.task04.Animal;
import com.mjuApps.springDemo.tasks.task04.AnimalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author marek_j on 2018-04-14
 */
@Configuration
public class StubbedServices {

    @Bean
    @Primary
    public AnimalService stubbedAnimalService() {
        return new AnimalService() {
            @Override
            public Animal buildAnimal(String name, Integer age) {
                return new Animal("Leszek",10);
            }
        };
    }

}
