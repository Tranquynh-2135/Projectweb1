package com.example.WebAnime.services;
import com.example.WebAnime.models.Genre;
import com.example.WebAnime.repository.genreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class genreService {
    @Autowired
    private genreRepository genreRepository;

    // Lấy tất cả các thể loại
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    // Lấy thể loại theo ID
    public Optional<Genre> getGenreById(Long id) {
        return genreRepository.findById(id);
    }

    // Lưu thể loại mới
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    // Xóa thể loại theo ID
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
