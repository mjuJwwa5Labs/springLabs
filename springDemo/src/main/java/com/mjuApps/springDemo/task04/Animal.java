package com.mjuApps.springDemo.task04;

public class Animal {

    private String name;
    private Integer age;

    public Animal(String name, Integer age) {
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
}
