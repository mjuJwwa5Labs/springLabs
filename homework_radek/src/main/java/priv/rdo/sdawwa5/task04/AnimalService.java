package priv.rdo.sdawwa5.task04;

import org.springframework.stereotype.Service;
import priv.rdo.sdawwa5.task02.Animal;

@Service
public class AnimalService {

    public Animal buildAnimal() {
        return new Animal("faflun", 666);
    }

}
