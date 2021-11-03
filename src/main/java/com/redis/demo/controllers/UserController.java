package com.redis.demo.controllers;

import com.redis.demo.models.UserDto;
import com.redis.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable String userId) {
        return userService.findUserById(userId)
                .orElseThrow(() -> new NoSuchElementException("User doesn't exist"));
    }

    @PostMapping
    public void saveUser(@RequestBody UserDto user) {
        userService.saveUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDto user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}
