package com.example.WebAnime.repository;

import com.example.WebAnime.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface genreRepository extends JpaRepository<Genre, Long> {
    List<Genre> findAll();
}
