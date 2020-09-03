package com.blogapp.service;

import com.blogapp.model.Post;
import com.blogapp.model.User;

import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PostService {

    Optional<Post> findForId(Long id);

    Post save(Post post);

    Page<Post> findByUserOrderedByDatePageable(User user, int page);

    Page<Post> findAllOrderedByDatePageable(int page);
    
    Page<Post> findAllApprovedIsFalseOrderedByDatePageable(int page);

    void delete(Post post);
}
