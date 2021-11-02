package com.redis.demo.services;

import com.redis.demo.models.UserDto;
import com.redis.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserDto> findUserById(String userId) {
        return userRepository.findById(userId);
    }


    public UserDto saveUser(UserDto user) {
        return userRepository.save(user);
    }

    public List<UserDto> findAllUsers() {
        List<UserDto> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
