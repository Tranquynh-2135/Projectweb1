package com.example.WebAnime.controllers;
import com.example.WebAnime.models.Anime;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.WebAnime.repository.animeRepository;
import com.example.WebAnime.services.animeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import com.example.WebAnime.models.Episode;
import com.example.WebAnime.repository.genreRepository;
import com.example.WebAnime.models.Genre;

import java.util.ArrayList;
import java.util.List;

@Controller
public class animeController {
    @Autowired
    private animeService animeService;

    @Autowired
    private animeRepository animeRepository;
    @Autowired
    private genreRepository genreRepository;


    // Khởi tạo danh sách Anime
    public animeController() {
    }




//    @GetMapping("/anime/byGenre/{genreId}")
//    public String getAnimeByGenre(@PathVariable Long genreId, Model model) {
//        List<Anime> animes = animeService.getAnimesByGenre(genreId); // Giả sử có một method trong service để lấy anime theo thể loại
//        model.addAttribute("animes", animes);
//        return "anime_list"; // Tên của view hiển thị danh sách anime
//    }


    @GetMapping("/episode/detail/{animeId}/{episodeNumber}")
    public String getEpisodeDetail(@PathVariable Long animeId, @PathVariable Integer episodeNumber, Model model) {
        // Tìm anime theo ID
        Anime anime = animeRepository.findById(animeId).orElse(null);

        if (anime == null) {
            return "error"; // Nếu không tìm thấy anime
        }

        // Tìm tập hiện tại theo số tập
        Episode currentEpisode = anime.getEpisodes().stream()
                .filter(episode -> episode.getEpisodeNumber().equals(episodeNumber))
                .findFirst()
                .orElse(null); // Nếu không tìm thấy tập, trả về null

        if (currentEpisode == null) {
            return "error"; // Nếu không tìm thấy tập hiện tại
        }

        // Tìm tập tiếp theo và tập trước
        int currentIndex = anime.getEpisodes().indexOf(currentEpisode);
        Episode nextEpisode = (currentIndex < anime.getEpisodes().size() - 1) ? anime.getEpisodes().get(currentIndex + 1) : null;
        Episode previousEpisode = (currentIndex > 0) ? anime.getEpisodes().get(currentIndex - 1) : null;

        // Truyền các đối tượng vào model để hiển thị trong view
        model.addAttribute("anime", anime);
        model.addAttribute("currentEpisode", currentEpisode);
        model.addAttribute("nextEpisode", nextEpisode);
        model.addAttribute("previousEpisode", previousEpisode);

        return "episodeDetail"; // Trả về view episodeDetail
    }

    @GetMapping("")
    public String getHomePage(@RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 8; // Số anime mỗi trang
        Page<Anime> animePage = animeService.findPaginated(page, pageSize);

        // Kiểm tra số trang
        int totalPages = animePage != null ? animePage.getTotalPages() : 0;
        if (page < 0 || page >= totalPages) {
            page = 0; // Reset về trang đầu nếu giá trị không hợp lệ
        }

        // Thêm dữ liệu vào model
        model.addAttribute("animes", animePage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages > 0 ? totalPages : 1); // Đảm bảo luôn có ít nhất 1 trang
//      them list the loai
        List<Genre> genres = genreRepository.findAll();
        model.addAttribute("genres", genres);

        return "index";
    }
    // Endpoint tìm kiếm
    @GetMapping("/search")
    public String searchAnime(@RequestParam("keyword") String keyword, Model model) {
        List<Anime> searchResults = animeService.searchAnime(keyword);
        model.addAttribute("animes", searchResults);
        model.addAttribute("keyword", keyword);
        return "index"; // Hiển thị kết quả trên trang home
    }

    // Điều hướng tới trang chi tiết anime
    @GetMapping("/anime/detail/{id}")
    public String getAnimeDetail(@PathVariable Long id, Model model) {
        Anime anime = animeRepository.findById(id).orElse(null); // Gọi từ đối tượng animeRepository
        model.addAttribute("anime", anime);
        return "detail";  // Trả về trang detail.html
    }





    // Trả về danh sách Anime
    @GetMapping("/animes")
    @ResponseBody
    public List<Anime> getAnimeList() {
        return animeService.findAll();
    }


    // Trả về một User cụ thể theo ID
    @GetMapping("/animes/{id}")  // Thêm dấu ngoặc kép đóng
    public ResponseEntity<Anime> getAnimeById(@PathVariable("id") long animeId) {
        // Không cần @ResponseBody vì ResponseEntity đã bao gồm body
        for (Anime anime : animeService.findAll()) {
            if (anime.getId() == animeId) {
                return ResponseEntity.status(200).body(anime);
            }
        }
        return ResponseEntity.status(404).body(null);  // Trả về lỗi 404 nếu không tìm thấy
    }


    @DeleteMapping("/animes/{id}")
    @ResponseBody
    public List<Anime> removeAnimeById(@PathVariable("id") Long animeId) {
        animeService.delete(animeId);
        return  animeService.findAll();
    }


    @PostMapping("/anime")
    public ResponseEntity<Anime> createAnime(@RequestBody Anime anime) {
        animeService.save(anime);
        return ResponseEntity.status(201).body(anime);
    }


    @PutMapping("/anime/{id}")
    public ResponseEntity<Anime> udpateAnime(@PathVariable("id") Long animeId, @RequestBody Anime updateAnime){
        Anime anime = animeService.findById(animeId);
        if (anime != null) {
            anime.setTitle(updateAnime.getTitle());
            anime.setDescription(updateAnime.getDescription());
            anime.setReleaseYear(updateAnime.getReleaseYear());
            anime.setRating(updateAnime.getRating());
            anime.setCoverImage(updateAnime.getCoverImage());
            anime.setEpisodes(updateAnime.getEpisodes());
            anime.setGenres(updateAnime.getGenres());
            animeService.save(anime);
            return ResponseEntity.status(200).body(anime);
        }
        return ResponseEntity.status(404).body(null);
    }
}
