package com.blogapp.controller;

import com.blogapp.model.User;
import com.blogapp.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AdminRegistrationController {

    private final AdminService adminService;

    @Autowired
    public AdminRegistrationController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/admin-registration", method = RequestMethod.GET)
    public String adminRegistration(Model model) {

        model.addAttribute("user", new User());
        return "/admin-registration";
    }

    @RequestMapping(value = "/admin-registration", method = RequestMethod.POST)
    public String createNewUserAdmin(@Valid User user,
                                BindingResult bindingResult,
                                Model model) {

        if (adminService.findByEmail(user.getEmail()).isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (adminService.findByUsername(user.getUsername()).isPresent()) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }

        if (!bindingResult.hasErrors()) {
            adminService.save(user);

            model.addAttribute("successMessage", "Admin has been registered.");
            model.addAttribute("user", new User());
        }

        return "/admin-registration";
    }
}
