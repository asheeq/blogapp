package com.blogapp.service;

import java.util.List;
import java.util.Optional;

import com.blogapp.model.User;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);

    List<User> findAllApprovedIsFalse();
    Optional<User> findById(long id);

    List<User> findAllApprovedIsTrue();

}
