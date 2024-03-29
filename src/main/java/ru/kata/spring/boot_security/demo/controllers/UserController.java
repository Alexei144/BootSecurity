package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;
    @Autowired
    UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getUser(ModelMap model, Principal principal) {
        model.addAttribute("user", userService.findByName(principal.getName()));
        return "user";
    }
}
