package com.example.WebAnime.repository;
import com.example.WebAnime.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface episodeRepository extends JpaRepository<Episode, Long> {
    List<Episode> findByAnimeId(Long animeId);
}
