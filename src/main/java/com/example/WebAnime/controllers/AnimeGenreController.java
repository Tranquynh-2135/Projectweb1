package com.example.WebAnime.controllers;
import com.example.WebAnime.models.AnimeGenre;
import com.example.WebAnime.services.AnimeGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anime-genre")
public class AnimeGenreController {
    @Autowired
    private AnimeGenreService animeGenreService;

    // Thêm Anime-Genre mới
    @PostMapping
    public ResponseEntity<AnimeGenre> addAnimeGenre(@RequestBody AnimeGenre animeGenre) {
        AnimeGenre createdAnimeGenre = animeGenreService.addAnimeGenre(animeGenre);
        return ResponseEntity.status(201).body(createdAnimeGenre);
    }

    // Lấy Anime-Genre theo ID
    @GetMapping("/{id}")
    public ResponseEntity<AnimeGenre> getAnimeGenreById(@PathVariable Long id) {
        AnimeGenre animeGenre = animeGenreService.getAnimeGenreById(id);
        if (animeGenre != null) {
            return ResponseEntity.status(200).body(animeGenre);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Xóa Anime-Genre theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimeGenre(@PathVariable Long id) {
        animeGenreService.deleteAnimeGenre(id);
        return ResponseEntity.status(204).build();
    }
}
