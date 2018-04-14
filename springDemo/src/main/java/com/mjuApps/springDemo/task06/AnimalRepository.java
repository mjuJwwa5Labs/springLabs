package com.mjuApps.springDemo.task06;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author marek_j on 2018-04-14
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{
    List<Animal> findByName(String name);

    List<Animal> findByAge(Integer age);

    List<Animal> findByNameOrAge(String name, Integer age);

    List<Animal> findFirst3ByOrderByNameDesc();
}
