package academy.devdojo.anime_service.controllers;


import academy.devdojo.anime_service.domain.Anime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animes")
@Slf4j
public class AnimeController {

    @GetMapping
    public List<Anime> findAll(){
        return Anime.getListAnimes();
    }

    @GetMapping("filter")
    public List<Anime> getNameByParam(@RequestParam(required = false) String name){
        var animes = Anime.getListAnimes();

        if (name == null) return animes;

        return animes.stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).toList();
    }

    @GetMapping("{id}")
    public Anime getById(@PathVariable Long id){
       return Anime.getListAnimes().stream()
               .filter(anime -> anime.getId().equals(id))
               .findFirst().orElse(null);
    }

}
