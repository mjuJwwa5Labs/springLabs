package priv.rdo.sdawwa5.task06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import priv.rdo.sdawwa5.task02.Animal;

import javax.annotation.PostConstruct;

@Configuration
public class SampleDataInitializer {
    private static final Logger LOG = LoggerFactory.getLogger(SampleDataInitializer.class);

    private final AnimalRepository animalRepository;

    public SampleDataInitializer(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @PostConstruct
    void init() {
        LOG.warn("init");
        animalRepository.save(new Animal("Stefan", 3));
        animalRepository.save(new Animal("Stefan", 4));
        animalRepository.save(new Animal("Mściwór", 6));
        animalRepository.save(new Animal("Mściwór", 4));
        animalRepository.save(new Animal("Andrzej", 3));
    }
}
