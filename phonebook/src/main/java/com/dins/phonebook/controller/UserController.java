package com.dins.phonebook.controller;

import com.dins.phonebook.entity.User;
import com.dins.phonebook.service.UserService;
import com.dins.phonebook.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path="/{id}")
    public @ResponseBody
    EntityModel<User> getUser (@PathVariable Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody
    void deleteUser (@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewUser(@RequestBody User user){
        userService.addUser(user);
        return "Saved";
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody
    String updateUser(@PathVariable Long id, @RequestBody Map<String, String> name){
        userService.updateName(id, name.get("name"));
        return "Updated";
    }
}
