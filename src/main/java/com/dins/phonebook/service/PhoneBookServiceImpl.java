package com.dins.phonebook.service;

import com.dins.phonebook.controller.MainController;
import com.dins.phonebook.controller.UserPhoneBookNoteController;
import com.dins.phonebook.entity.PhoneBookNote;
import com.dins.phonebook.entity.User;
import com.dins.phonebook.exception.NoteNotFoundException;
import com.dins.phonebook.exception.UserNotFoundException;
import com.dins.phonebook.repository.PhoneBookRepository;
import com.dins.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@Qualifier("phoneBookService")
public class PhoneBookServiceImpl implements PhoneBookService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneBookRepository phoneBookRepository;

    @Override
    public Optional<PhoneBookNote> getPhoneBookNoteById(Long id) {
        return Optional.empty();
    }

    @Override
    public Iterable<PhoneBookNote> getUserPhoneBook(Long id) {
        Optional<User> user = userRepository.findById(id);
        user.orElseThrow(() -> new UserNotFoundException(id));
        return phoneBookRepository.findPhoneBookNotesByUserId(id);
    }

    @Override
    public EntityModel<PhoneBookNote> getPhoneBookNoteByUserIdAndId(Long id, Long noteId) {
        PhoneBookNote phoneBookNote = phoneBookRepository.findPhoneBookNoteByUserIdAndId(id, noteId)
                .orElseThrow(() -> new NoteNotFoundException(id));
        return EntityModel.of(phoneBookNote,
                linkTo(methodOn(UserPhoneBookNoteController.class).getNote(id, noteId)).withSelfRel(),
                linkTo(methodOn(UserPhoneBookNoteController.class).getNotes(id)).withRel("user_notes"));
    }

    @Override
    public void deletePhoneBookNote(Long id) {

    }

    @Override
    public void addPhoneBookNote(Long id, PhoneBookNote phoneBookNote) {

    }
}
