package academy.devdojo.anime_service.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Anime {

    private Long id;
    private String name;
    private static List<Anime> animes = new ArrayList<>();

    static {
        var naruto = new Anime(1L, "Naruto");
        var onePice = new Anime(2L, "One Piece");
        var bleach = new Anime(3L, "Bleach");
        animes.addAll(List.of(naruto, onePice, bleach));
    }


    public static List<Anime> getListAnimes() {
       return animes;
    }

}
