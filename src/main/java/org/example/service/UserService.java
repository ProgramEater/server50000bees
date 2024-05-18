package org.example.service;

import org.example.controller.dto.UserProfileDto;
import org.example.controller.dto.UserRegisterDto;

import org.example.domain.Authority;

import java.util.List;

public interface UserService {
    UserProfileDto add(UserRegisterDto user);
    List<UserProfileDto> getAll();
    UserProfileDto getById(Long id);
    UserProfileDto update(Long id, UserProfileDto userProfileDto);
    void update(Long id, Authority authority);
    void deleteById(Long id);

    UserProfileDto getByUsername(String username);

}