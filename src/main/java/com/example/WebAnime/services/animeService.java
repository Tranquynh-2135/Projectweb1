package com.example.WebAnime.services;
import com.example.WebAnime.models.Anime;
import com.example.WebAnime.repository.animeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import com.example.WebAnime.models.Episode;
@Service
public class animeService {
    @Autowired
    private animeRepository animeRepository;


    public List<Anime> findAll() {
        return animeRepository.findAll();
    }


    public Anime findById(Long id) {
        return animeRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }


    public Anime save(Anime anime) {
        return animeRepository.save(anime);
    }


    public Anime update(Anime anime) {
        return animeRepository.save(anime);
    }
    public void delete(Long id) {
        animeRepository.deleteById(id);
    }

    public Page<Anime> findPaginated(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Anime> animePage = animeRepository.findAll(pageable);

        // Kiểm tra nếu animePage trống
        if (animePage.isEmpty()) {
            return Page.empty();
        }

        return animePage;
    }

    public List<Anime> searchAnime(String keyword) {
        return animeRepository.searchByTitle(keyword);
    }

    public Episode findEpisodeById(Long id) {
        // Tìm tập dựa trên ID
        for (Anime anime : animeRepository.findAll()) {
            for (Episode episode : anime.getEpisodes()) {
                if (episode.getId().equals(id)) {
                    return episode;
                }
            }
        }
        return null;  // Nếu không tìm thấy tập
    }

//    public List<Anime> getAnimesByGenre(Long genreId) {
//        return animeRepository.findByGenreId(genreId);
//    }
}
