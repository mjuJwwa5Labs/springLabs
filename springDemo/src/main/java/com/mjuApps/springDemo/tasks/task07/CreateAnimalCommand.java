package com.mjuApps.springDemo.tasks.task07;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author marek_j on 2018-04-15
 */
public class CreateAnimalCommand {

    @NotNull(message = "name can't be empty or null")
    @NotEmpty(message = "name can't be empty or null")
    private String name;

    @NotNull(message = "age can't be null")
    @Min(value = 0, message = "age can't be less then 0")
    private Integer age;

    public CreateAnimalCommand() {
    }

    public CreateAnimalCommand(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
