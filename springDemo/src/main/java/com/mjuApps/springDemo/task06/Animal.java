package com.mjuApps.springDemo.task06;

import javax.persistence.*;

@Entity
@Table(name = "animals")
class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    public Animal(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Animal() {}

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }
}