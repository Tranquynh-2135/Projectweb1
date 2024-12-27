package com.example.WebAnime.services;
import com.example.WebAnime.dto.UserDto;
import com.example.WebAnime.models.User;

import java.util.List;
public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
