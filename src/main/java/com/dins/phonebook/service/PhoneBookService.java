package com.dins.phonebook.service;

import com.dins.phonebook.domain.PhoneBookNote;
import org.springframework.hateoas.EntityModel;

import java.util.Optional;

public interface PhoneBookService {
    Optional<PhoneBookNote> getPhoneBookNoteById(Long id);
    Iterable<PhoneBookNote> getUserPhoneBook(Long id);
    EntityModel<PhoneBookNote> getPhoneBookNoteByUserIdAndId(Long id, Long noteId);
    void deletePhoneBookNote(Long id);
    void deletePhoneBookNoteByUserIdAndPhoneBookId(Long id, Long phoneBookNoteId);
    void addPhoneBookNote(Long id, PhoneBookNote phoneBookNote);
    void updatePhoneBookNoteByUserIdAndId(Long id, Long noteId, String name, String phoneNumber);
    Iterable<PhoneBookNote> getPhoneBookNotesByPhoneNumber(String phoneNumber);
}
