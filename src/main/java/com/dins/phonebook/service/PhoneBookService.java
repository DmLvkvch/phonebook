package com.dins.phonebook.service;

import com.dins.phonebook.entity.PhoneBookNote;
import com.dins.phonebook.entity.User;
import org.springframework.hateoas.EntityModel;

import java.util.Optional;

public interface PhoneBookService {
    Optional<PhoneBookNote> getPhoneBookNoteById(Long id);
    Iterable<PhoneBookNote> getUserPhoneBook(Long id);
    EntityModel<PhoneBookNote> getPhoneBookNoteByUserIdAndId(Long id, Long noteId);
    void deletePhoneBookNote(Long id);
    void addPhoneBookNote(Long id, PhoneBookNote phoneBookNote);
}
