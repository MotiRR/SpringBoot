package org.vtb.edu.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.vtb.edu.database.dto.User;
import org.vtb.edu.service.UserService;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/all")
    public String getAllBoxes(Model model) {
        model.addAttribute("frontUsers", userService.getAllUsers());
        return "all_users";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute User user) {
        userService.saveOrUpdateUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/user/edit/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("frontUser", userService.getUserById(id));
        return "/user_edit_page";
    }

    @PostMapping("user/edit")
    public String editUser(@ModelAttribute User user) {
        userService.saveOrUpdateUser((user));
        return "redirect:/users/all";
    }

    @GetMapping("/user/remove/{id}")
    public String removeUserById(@PathVariable Long id) {
        userService.removeUserById(id);
        return "redirect:/users/all";
    }

}
