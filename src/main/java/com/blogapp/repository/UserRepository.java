package com.blogapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.blogapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByApprovedIsTrueAndEmail(@Param("email") String email);

    Optional<User> findByApprovedIsTrueAndUsername(@Param("username") String username);

    Optional<User> findRoleByUsername(@Param("role") String username);

    Optional<User> findById(@Param("user_id") long id);

    List<User> findAllByApprovedIsFalse();
}
