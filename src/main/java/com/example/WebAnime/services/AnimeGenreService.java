package com.example.WebAnime.services;
import com.example.WebAnime.models.AnimeGenre;
import com.example.WebAnime.repository.AnimeGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimeGenreService {
    @Autowired
    private AnimeGenreRepository animeGenreRepository;

    // Thêm một AnimeGenre mới
    public AnimeGenre addAnimeGenre(AnimeGenre animeGenre) {
        return animeGenreRepository.save(animeGenre);
    }

    // Tìm AnimeGenre theo ID
    public AnimeGenre getAnimeGenreById(Long id) {
        return animeGenreRepository.findById(id).orElse(null);
    }

    // Xóa AnimeGenre theo ID
    public void deleteAnimeGenre(Long id) {
        animeGenreRepository.deleteById(id);
    }

}
