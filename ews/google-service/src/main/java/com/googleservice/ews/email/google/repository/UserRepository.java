package com.googleservice.ews.email.google.repository;

import com.dmlvkvch.oauth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
