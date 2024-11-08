package com.example.WebAnime.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "anime_genre")
public class AnimeGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "anime_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Anime anime;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Genre genre;

    // Constructor mặc định
    public AnimeGenre() {
    }

    // Constructor khởi tạo
    public AnimeGenre(Anime anime, Genre genre) {
        this.anime = anime;
        this.genre = genre;
    }

    // Getters và setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
