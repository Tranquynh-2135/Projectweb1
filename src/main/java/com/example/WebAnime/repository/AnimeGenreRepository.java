package com.example.WebAnime.repository;
import com.example.WebAnime.models.AnimeGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeGenreRepository extends JpaRepository<AnimeGenre, Long> {
}
