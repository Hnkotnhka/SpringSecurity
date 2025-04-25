package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserServiceImp;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserServiceImp userService;

    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showUser(Model model, Authentication authentication) {
        String auth = authentication.getName();
        User user = userService.getByName(auth);
        model.addAttribute("user", user);
        return "user";
    }
}
