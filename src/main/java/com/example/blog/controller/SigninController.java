package com.example.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SigninController {
    @GetMapping("/signin")
    public String login(Principal principal){
        if (principal!=null){
            return "redirect:/home";
        }
        return "/signin";
    }
}
