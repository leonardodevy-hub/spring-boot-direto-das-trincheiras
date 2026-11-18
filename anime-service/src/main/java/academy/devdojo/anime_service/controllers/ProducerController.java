package academy.devdojo.anime_service.controllers;


import academy.devdojo.anime_service.domain.Producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/v1/producers")
@Slf4j
public class ProducerController {

    @GetMapping
    public List<Producer> findAll() {
        return Producer.getListProducers();
    }

    @GetMapping("filter")
    public List<Producer> getNameByParam(@RequestParam(required = false) String name) {
        var producers = Producer.getListProducers();

        if (name == null) return producers;

        return producers.stream().filter(producer -> producer.getName().equalsIgnoreCase(name)).toList();
    }

    @GetMapping("{id}")
    public Producer getById(@PathVariable Long id) {
        return Producer.getListProducers().stream()
                .filter(producer -> producer.getId().equals(id))
                .findFirst().orElse(null);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE,
    headers = "x-api-kye")
    public Producer save(@RequestBody Producer producer, @RequestHeader HttpHeaders headers) {
        log.info("{}",headers);
        producer.setId(ThreadLocalRandom.current().nextLong(100_000));
        Producer.getListProducers().add(producer);
        return producer;
    }

}
