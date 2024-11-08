package com.example.WebAnime.services;

import com.example.WebAnime.models.Episode;
import com.example.WebAnime.repository.episodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class episodeService {
    @Autowired
    private episodeRepository episodeRepository;

    // Lấy tất cả các episode
    public List<Episode> getAllEpisodes() {
        return episodeRepository.findAll();
    }

    // Lấy episode theo id
    public Optional<Episode> getEpisodeById(Long id) {
        return episodeRepository.findById(id);
    }

    // Lấy các episode của một anime
    public List<Episode> getEpisodesByAnimeId(Long animeId) {
        return episodeRepository.findByAnimeId(animeId);
    }

    // Thêm episode mới
    public Episode saveEpisode(Episode episode) {
        return episodeRepository.save(episode);
    }

    // Cập nhật episode
    public Episode updateEpisode(Episode episode) {
        return episodeRepository.save(episode);
    }

    // Xóa episode theo id
    public void deleteEpisode(Long id) {
        episodeRepository.deleteById(id);
    }
}
