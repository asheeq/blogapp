package com.blogapp.repository;

import com.blogapp.model.Post;
import com.blogapp.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByUserAndApprovedIsTrueOrderByCreateDateDesc(User user, Pageable pageable);
    
    Page<Post> findAllByApprovedIsTrueOrderByCreateDateDesc(Pageable pageable);

    Page<Post> findAllByApprovedIsFalseOrderByCreateDateDesc(Pageable pageable);
    
    Optional<Post> findById(Long id);
}
