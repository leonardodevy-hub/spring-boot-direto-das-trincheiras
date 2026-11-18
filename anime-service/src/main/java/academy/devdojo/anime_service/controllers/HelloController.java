package academy.devdojo.anime_service.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("v1/greetings")
@Slf4j
public class HelloController {

    @GetMapping
    public String hi() {
        return "Hello";
    }

    @PostMapping
    public Long save(String name){
        log.info("save '{}'", name);
        return ThreadLocalRandom.current().nextLong(1, 1000);
    }
}
