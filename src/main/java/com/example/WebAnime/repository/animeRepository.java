package com.example.WebAnime.repository;
import com.example.WebAnime.models.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface animeRepository extends JpaRepository<Anime, Long>{
    Page<Anime> findAll(Pageable pageable);

    @Query("SELECT a FROM Anime a WHERE LOWER(a.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Anime> searchByTitle(@Param("keyword") String keyword);

//    List<Anime> findByGenreId(Long genreId);
}
