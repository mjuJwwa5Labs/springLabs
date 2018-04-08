package com.mjuApps.springDemo.task03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class Task03Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Task03Controller.class);

    @PostMapping(value = "task03-0-0")
    @ResponseStatus(HttpStatus.CREATED)
    public void doPostAnimal(@RequestBody Animal animal) {
        LOG.info("Received animal = " + animal.toString());
    }

    @PostMapping(value = "task03-0-1")
    public ResponseEntity<Void> doPostAnimalWithResponseEntity(@RequestBody Animal animal) {
        LOG.info("Received animal = " + animal.toString());
        return ResponseEntity.accepted()
                .header(LocalDateTime.now().toString())
                .build();
    }

}
