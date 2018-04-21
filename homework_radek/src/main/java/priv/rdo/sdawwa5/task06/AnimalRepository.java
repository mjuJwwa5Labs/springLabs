package priv.rdo.sdawwa5.task06;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import priv.rdo.sdawwa5.task02.Animal;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
    List<Animal> findByName(String name);

    List<Animal> findByAge(int age);

    List<Animal> findByNameAndAge(String name, int age);

    List<Animal> findFirst3ByOrderByAgeDesc();
}
