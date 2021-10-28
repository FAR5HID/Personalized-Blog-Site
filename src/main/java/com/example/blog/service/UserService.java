package com.example.blog.service;

import com.example.blog.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    User save(User save);
}