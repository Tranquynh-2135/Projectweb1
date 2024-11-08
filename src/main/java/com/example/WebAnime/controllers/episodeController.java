package com.example.WebAnime.controllers;
import com.example.WebAnime.models.Episode;
import com.example.WebAnime.services.episodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/episodes")
public class episodeController {
    @Autowired
    private episodeService episodeService;



    // Lấy tất cả episodes
    @GetMapping
    public List<Episode> getAllEpisodes() {
        return episodeService.getAllEpisodes();
    }

    // Lấy episode theo id
    @GetMapping("/{id}")
    public ResponseEntity<Episode> getEpisodeById(@PathVariable Long id) {
        Optional<Episode> episode = episodeService.getEpisodeById(id);
        if (episode.isPresent()) {
            return ResponseEntity.ok(episode.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Lấy các episode của một anime
    @GetMapping("/anime/{animeId}")
    public List<Episode> getEpisodesByAnimeId(@PathVariable Long animeId) {
        return episodeService.getEpisodesByAnimeId(animeId);
    }

    // Thêm mới episode
    @PostMapping
    public Episode createEpisode(@RequestBody Episode episode) {
        return episodeService.saveEpisode(episode);
    }

    // Cập nhật episode
    @PutMapping("/{id}")
    public ResponseEntity<Episode> updateEpisode(@PathVariable Long id, @RequestBody Episode episodeDetails) {
        Optional<Episode> existingEpisode = episodeService.getEpisodeById(id);
        if (existingEpisode.isPresent()) {
            Episode episode = existingEpisode.get();
            episode.setEpisodeNumber(episodeDetails.getEpisodeNumber());
            episode.setTitle(episodeDetails.getTitle());
            episode.setVideoUrl(episodeDetails.getVideoUrl());
            episode.setAnime(episodeDetails.getAnime());
            return ResponseEntity.ok(episodeService.updateEpisode(episode));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa episode
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEpisode(@PathVariable Long id) {
        Optional<Episode> existingEpisode = episodeService.getEpisodeById(id);
        if (existingEpisode.isPresent()) {
            episodeService.deleteEpisode(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
