package com.blogapp.service.impl;

import com.blogapp.model.User;
import com.blogapp.repository.RoleRepository;
import com.blogapp.repository.UserRepository;
import com.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByApprovedIsTrueAndUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByApprovedIsTrueAndEmail(email);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        user.setRoles(Collections.singletonList(roleRepository.findByRole("ROLE_USER")));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findAllApprovedIsFalse() {
        return userRepository.findAllByApprovedIsFalse();
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllApprovedIsTrue() {
        return userRepository.findAllByApprovedIsFalse();
    }
}
