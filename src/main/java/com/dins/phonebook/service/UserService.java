package com.dins.phonebook.service;

import com.dins.phonebook.entity.User;
import org.springframework.hateoas.EntityModel;

public interface UserService {
    EntityModel<User> getUser(Long id);
    Iterable<User> getAllUsers();
    Iterable<User> getUsersByNameLike(String name);
    void deleteUser(Long id);
    void addUser(User user);
    void updateUser(User user);
    void updateName(Long id, String name);
}
