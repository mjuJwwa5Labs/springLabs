package priv.rdo.sdawwa5.task07;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import priv.rdo.sdawwa5.task02.Animal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
class CreateAnimalCommand {
    @NotBlank(message = "name cannot be empty")
    @Size(min = 3, message = "name too short, min 3 signs")
    private String name;

    @NotNull(message = "age cannot be empty")
    @Min(value = 0, message = "come on, animals cant have negative age")
    private Integer age;

    Animal toAnimal() {
        return new Animal(name, age);
    }
}
