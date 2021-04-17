package com.googleservice.ews.email.google.service;


import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.dmlvkvch.oauth.authenticate.OAuth2;
import com.dmlvkvch.oauth.domain.User;
import com.googleservice.ews.email.google.repository.OAuth2Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;

@Service
@Qualifier("googleOAuthService")
public class GoogleOAuthServiceImpl implements GoogleOAuthService {

    @Autowired
    private OAuth2 googleAuthenticate;

    @Autowired
    private OAuth2Credentials oAuth2Repository;

    @Override
    public URI getOAuthUri() {
        return googleAuthenticate.getAuthenticateUrl();
    }

    @Override
    public AccessToken getAccessToken(Map<String, String> authCode) {
        return googleAuthenticate.getAccessToken(authCode);
    }

    @Override
    public void saveAccessToken(User user, AccessToken accessToken) {

    }

    @Override
    public void updateAccessToken(User user, AccessToken accessToken) {

    }

    @Override
    public void deleteAccessToken(User user, AccessToken accessToken) {

    }
}
