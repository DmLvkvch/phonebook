package com.dins.phonebook.repository;

import com.dins.phonebook.entity.PhoneBookNote;
import com.dins.phonebook.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PhoneBookRepository extends CrudRepository<PhoneBookNote, Long> {
    Iterable<PhoneBookNote> findPhoneBookNotesByUserId(Long id);
    Optional<PhoneBookNote> findPhoneBookNoteByUserIdAndId(Long id, Long noteId);
}
