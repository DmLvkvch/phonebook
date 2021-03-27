package com.dins.phonebook.controller;

import com.dins.phonebook.entity.User;
import com.dins.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/")
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping(path="/users")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path="/find")
    public @ResponseBody
    Iterable<User> getUserByName(@RequestParam String name) {
        return userService.getUsersByNameLike(name);
    }
}