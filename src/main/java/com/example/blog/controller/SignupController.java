package com.example.blog.controller;

import com.example.blog.model.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {
    private final UserService userService;

    @Autowired
    public SignupController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value="/signup", method = RequestMethod.GET)
    public String signup(Model model){
        model.addAttribute("user", new User());
        return "/signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String createNewUser(@Validated User user, BindingResult bindingResult, Model model){
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            bindingResult.rejectValue("email", "error.user", "There is already a user registered with this email");
        }
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            bindingResult.rejectValue("username", "error.user", "There is already a user registered with this username");
        }

        if (!bindingResult.hasErrors()) {
            userService.save(user);

            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new User());
        }

        return "/registration";
    }

}
