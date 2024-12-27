package com.example.WebAnime.repository;
import com.example.WebAnime.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {
        Role findByName(String name);
}
