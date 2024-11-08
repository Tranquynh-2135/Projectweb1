package com.example.WebAnime.controllers;
import com.example.WebAnime.models.Anime;
import com.example.WebAnime.models.Genre;
import com.example.WebAnime.repository.animeRepository;
import com.example.WebAnime.repository.genreRepository;
import com.example.WebAnime.services.animeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")

public class AdminController {
    @Autowired
    private animeService animeService;

    @Autowired
    private animeRepository animeRepository;

    @Autowired
    private genreRepository genreRepository;
    public AdminController(animeService animeService, animeRepository animeRepository, genreRepository genreRepository) {
        this.animeService = animeService;
        this.animeRepository = animeRepository;
        this.genreRepository = genreRepository;
    }

    // Trang quản lý anime
    @GetMapping("/anime")
    public String listAnimeForAdmin(Model model) {
        List<Anime> animes = animeService.findAll();  // Lấy danh sách anime từ service
        model.addAttribute("animes", animes);
        return "anime_list";  // Trả về trang liệt kê anime
    }

    // Trang thêm anime mới
    @GetMapping("/anime/new")
    public String showCreateAnimeForm(Model model) {
        model.addAttribute("anime", new Anime());  // Tạo một anime rỗng để người dùng điền thông tin
        List<Genre> genres = genreRepository.findAll();  // Lấy tất cả thể loại
        model.addAttribute("genres", genres);
        return "create_anime";  // Trả về trang tạo mới anime
    }

    // Lưu anime mới
    @PostMapping("/anime")
    public String createAnime(@ModelAttribute("anime") Anime anime) {
        animeService.save(anime);  // Lưu anime vào cơ sở dữ liệu
        return "redirect:/admin/anime";  // Quay lại trang danh sách anime
    }

    // Trang sửa anime
    @GetMapping("/anime/edit/{id}")
    public String showEditAnimeForm(@PathVariable("id") Long id, Model model) {
        Anime anime = animeRepository.findById(id).orElse(null);  // Lấy anime theo id
        if (anime == null) {
            return "error";  // Nếu không tìm thấy anime
        }
        model.addAttribute("anime", anime);
        List<Genre> genres = genreRepository.findAll();  // Lấy tất cả thể loại
        model.addAttribute("genres", genres);
        return "edit_anime";  // Trả về trang sửa anime
    }

    // Cập nhật anime
    @PostMapping("/anime/{id}")
    public String updateAnime(
            @PathVariable("id") Long id,
            @ModelAttribute("anime") Anime updatedAnime,
            @RequestParam("genres") List<Long> genreIds
    ) {
        Anime anime = animeRepository.findById(id).orElse(null);
        if (anime != null) {
            anime.setTitle(updatedAnime.getTitle());
            anime.setDescription(updatedAnime.getDescription());
            anime.setReleaseYear(updatedAnime.getReleaseYear());
            anime.setRating(updatedAnime.getRating());
            anime.setCoverImage(updatedAnime.getCoverImage());

            // Lấy danh sách thể loại từ ID
            List<Genre> genres = genreRepository.findAllById(genreIds);
            anime.setGenres(genres);

            animeService.save(anime);
        }
        return "redirect:/admin/anime";
    }

    // Xóa anime
    @GetMapping("/anime/delete/{id}")
    public String deleteAnime(@PathVariable("id") Long id) {
        animeService.delete(id);  // Xóa anime theo id
        return "redirect:/admin/anime";  // Quay lại trang quản lý anime
    }
}
