package com.redis.demo.services;

import com.redis.demo.models.UserDto;
import com.redis.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(key = "#userId", value = "user", unless = "#result.age < 18")
    public Optional<UserDto> findUserById(String userId) {
        System.out.println("Cached only results that follow to the condition: age >= 18");
        return userRepository.findById(userId);
    }


    public UserDto saveUser(UserDto user) {
        return userRepository.save(user);
    }

    @CachePut(key = "#updatedUser.getId()", value = "user")
    public UserDto updateUser(UserDto updatedUser) {
        if (!findUserById(updatedUser.getId()).isPresent()) {
            throw new NoSuchElementException("User doesn't exist");
        }
        return userRepository.save(updatedUser);
    }

    public List<UserDto> findAllUsers() {
        List<UserDto> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @CacheEvict(key = "#userId", value = "user")
    public void deleteUser(String userId) {
        if (!findUserById(userId).isPresent()) {
            throw new NoSuchElementException("User doesn't exist");
        }
        userRepository.deleteById(userId);
    }
}
