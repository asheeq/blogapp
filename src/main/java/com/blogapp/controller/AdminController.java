package com.blogapp.controller;

import com.blogapp.model.Post;
import com.blogapp.service.PostService;
import com.blogapp.util.Pager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private final PostService postService;

    @Autowired
    public AdminController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/admin")
    public String admin(@RequestParam(defaultValue = "0") int page,
                       Model model) {

        Page<Post> posts = postService.findAllOrderedByDatePageable(page);
        Pager pager = new Pager(posts);

        model.addAttribute("pager", pager);

        return "/admin";
    }
}
