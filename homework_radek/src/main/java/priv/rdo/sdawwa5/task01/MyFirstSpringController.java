package priv.rdo.sdawwa5.task01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstSpringController {
    @GetMapping("hello")
    String hello(@RequestParam(defaultValue = "World!") String name) {
        return "hello " + name;
    }

    @GetMapping("hello/{number}")
    String hello2(@PathVariable int number) {
        return "hello " + number + " World!";
    }

    @GetMapping("hello3/{number}")
    String hello3(@PathVariable int number,
                  @RequestParam(defaultValue = "World!") String name) {
        return "hello " + number + " " + name;
    }
}
