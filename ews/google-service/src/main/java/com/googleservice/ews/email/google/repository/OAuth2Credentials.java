package com.googleservice.ews.email.google.repository;

import com.dmlvkvch.oauth.domain.OAuth2UserAccessCredential;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuth2Credentials extends CrudRepository<OAuth2UserAccessCredential, Long> {
}
