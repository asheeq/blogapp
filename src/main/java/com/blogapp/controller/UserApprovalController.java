package com.blogapp.controller;

import com.blogapp.model.User;
import com.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class UserApprovalController {

    private final UserService userService;

    @Autowired
    public UserApprovalController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/admin-user-approval", method = RequestMethod.GET)
    public String unapprovedUser(Model model) {

        List<User> user = userService.findAllApprovedIsFalse();

        if(!user.isEmpty()){
            model.addAttribute("users", user);
            return "/admin-user-approval";
        }
        else {
            return "/error";
        }
    }

    @RequestMapping(value = "/admin-user-approve/{id}", method = RequestMethod.GET)
    public String adminUserApprove(@PathVariable Long id,
                                   Model model) {

        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setApproved(true);
            userService.save(user);
            model.addAttribute("user", user);

            return "redirect:/admin-user-approval";

        } else {
            return "/error";
        }
    }

    @RequestMapping(value = "/admin-user-deactivate", method = RequestMethod.GET)
    public String approvedUser(Model model) {

        List<User> user = userService.findAllApprovedIsTrue();

        if(!user.isEmpty()){
            model.addAttribute("users", user);
            return "/admin-user-approval";
        }
        else {
            return "/error";
        }
    }

    @RequestMapping(value = "/admin-user-deactivate/{id}", method = RequestMethod.GET)
    public String deactivateWithId(@PathVariable Long id,
                                   Model model) {

        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if(user.getApproved()){
                user.setApproved(false);
            }
            userService.save(user);
            model.addAttribute("user", user);
            return "redirect:/admin-user-approval";
        }  else {
            return "/error";
        }
    }
}
