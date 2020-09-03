package com.blogapp.controller;

import com.blogapp.model.Post;
import com.blogapp.service.PostService;
import com.blogapp.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class PostApprovalController {

    private final PostService postService;

    @Autowired
    public PostApprovalController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/admin-post-approval", method = RequestMethod.GET)
    public String unapprovedPost(@RequestParam(defaultValue = "0") int page,
                                 Model model) {

        Page<Post> posts = postService.findAllApprovedIsFalseOrderedByDatePageable(page);
        Pager pager = new Pager(posts);

        model.addAttribute("pager", pager);
        return "/admin";
    }
    @RequestMapping(value = "/admin-post-approval/{id}", method = RequestMethod.GET)
    public String getPostWithId(@PathVariable Long id,
                                Model model) {

        Optional<Post> optionalPost = postService.findForId(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            model.addAttribute("post", post);

            return "/admin-post-approval";

        } else {
            return "/error";
        }
    }
    @RequestMapping(value = "/admin-approve/{id}", method = RequestMethod.GET)
    public String adminApproved(@PathVariable Long id,
                                Model model) {

        Optional<Post> optionalPost = postService.findForId(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setApproved(true);

            postService.save(post);

            model.addAttribute("post", post);

            return "redirect:/admin-post-approval";

        } else {
            return "/error";
        }
    }

    @RequestMapping(value = "/admin-delete/{id}", method = RequestMethod.GET)
    public String deletePostWithId(@PathVariable Long id) {

        Optional<Post> optionalPost = postService.findForId(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            postService.delete(post);
            return "redirect:/admin";
        }  else {
            return "/error";
        }
    }
}
