package com.dins.phonebook.controller;

import com.dins.phonebook.entity.PhoneBookNote;
import com.dins.phonebook.entity.User;
import com.dins.phonebook.service.PhoneBookService;
import com.dins.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/user/{id}")
public class UserPhoneBookNoteController {

    @Autowired
    private PhoneBookService phoneBookService;

    @GetMapping(path="/notes")
    public @ResponseBody
    Iterable<PhoneBookNote> getNotes (@PathVariable Long id) {
        return phoneBookService.getUserPhoneBook(id);
    }

    @GetMapping(path="/note/{noteId}")
    public @ResponseBody
    EntityModel<PhoneBookNote> getNote (@PathVariable Long id, @PathVariable Long noteId) {
        return phoneBookService.getPhoneBookNoteByUserIdAndId(id, noteId);
    }
}
