package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.Users;
import web.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping()
    public String printAll(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users/index";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new Users());
        return "/users/newUser";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") Users user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

}
