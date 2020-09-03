package com.blogapp.service;

import java.util.Optional;

import com.blogapp.model.User;

public interface AdminService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);
}
