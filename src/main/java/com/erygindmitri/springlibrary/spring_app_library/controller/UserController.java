package com.erygindmitri.springlibrary.spring_app_library.controller;

import com.erygindmitri.springlibrary.spring_app_library.models.User;
import com.erygindmitri.springlibrary.spring_app_library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        User user = userService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        return "login";

    }

    @GetMapping("/registration")
    public String registration(Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));

        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model){
        if(!userService.createUser(user)){
            model.addAttribute("errorMessage", "Пользователь с email "
                    + user.getEmail() + " существует");
            return "registration";
        }
        return "redirect:/login";
    }

}
