package academy.devdojo.anime_service.controllers;


import academy.devdojo.anime_service.domain.Producer;
import academy.devdojo.anime_service.mapper.ProducerMapper;
import academy.devdojo.anime_service.request.ProducerPostRequest;
import academy.devdojo.anime_service.response.ProducerGetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/producers")
@Slf4j
public class ProducerController {


    private static final ProducerMapper MAPPER = ProducerMapper.INSTANCE;

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
    headers = "x-api-key")
    public ResponseEntity<ProducerGetResponse> save(@RequestBody ProducerPostRequest producerPostRequest, @RequestHeader HttpHeaders headers) {
        log.info("{}",headers);

        var producer = MAPPER.toProducer(producerPostRequest);
        var response = MAPPER.toProducerGetResponse(producer);


        Producer.getListProducers().add(producer);



        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
