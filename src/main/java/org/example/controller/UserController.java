package org.example.controller;

import org.example.controller.dto.UserProfileDto;
import org.example.controller.dto.UserRegisterDto;
import org.example.domain.Authority;

import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserProfileDto add(@RequestBody UserRegisterDto userRegisterDto) {
        return userService.add(userRegisterDto);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserProfileDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserProfileDto getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserProfileDto update(@PathVariable Long id, @RequestBody UserProfileDto userProfileDto) {
        return userService.update(id, userProfileDto);
    }

    @PutMapping("/authority/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody Authority authority) {
        userService.update(id, authority);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable long id) {
        userService.deleteById(id);
    }

    @GetMapping("/username/{username}")
    @ResponseStatus(HttpStatus.OK)
    public String getByUsername(@PathVariable String username) {
        UserProfileDto userProfileDto = userService.getByUsername(username);
        return "User " + userProfileDto.getUsername() + " is registered";
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserProfileDto login(Authentication authentication) {
        return userService.getByUsername(authentication.getName());
    }
}
