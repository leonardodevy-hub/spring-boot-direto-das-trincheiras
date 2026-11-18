package academy.devdojo.anime_service.domain;


import lombok.Getter;

import java.util.List;

@Getter
public class Anime {

    private Long id;
    private String name;

    public Anime(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Anime> getListAnimes (){
        var naruto = new Anime(1L, "Naruto");
        var onePice = new Anime(2L, "One Piece");
        var bleach = new Anime(3L, "Bleach");

        return List.of(naruto, onePice, bleach);
    }

}
