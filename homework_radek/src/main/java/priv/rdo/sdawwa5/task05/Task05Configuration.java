package priv.rdo.sdawwa5.task05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Task05Configuration {

    @Bean
    NotManagedBySpring notManagedBySpring() {
        return new NotManagedBySpring("testval");
    }

    @Bean
    NotManagedBySpring notManagedBySpring2() {
        return new NotManagedBySpring("testval23");
    }

    @Bean
    String alaMaKota() {
        return "alaMaKota";
    }
}
