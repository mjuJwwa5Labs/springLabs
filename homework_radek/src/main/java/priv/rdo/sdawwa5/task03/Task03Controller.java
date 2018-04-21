package priv.rdo.sdawwa5.task03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import priv.rdo.sdawwa5.task02.Animal;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
public class Task03Controller {
    private static final Logger LOG = LoggerFactory.getLogger(Task03Controller.class);

    @PostMapping(value = "task03")
    @ResponseStatus(HttpStatus.CREATED)
    void addAnimal(@RequestBody Animal animal) {
        LOG.info("Received animal: {}", animal);
    }

    @PostMapping(value = "task03respEnt")
    ResponseEntity<Void> addAnimal2(@RequestBody Animal animal) {
        LOG.info("Received animal: {}", animal);

        return ResponseEntity.created(URI.create("localhost:8080/task03/??")).build();
    }

    @PostMapping(value = "task03ext")
    ResponseEntity<Void> addAnimal2Ext(@RequestBody Animal animal) {
        LOG.info("Received animal: {}", animal);

        return ResponseEntity
                .accepted()
                .header("Last-Modified", LocalDateTime.now().toString())
                .build();
    }
}
