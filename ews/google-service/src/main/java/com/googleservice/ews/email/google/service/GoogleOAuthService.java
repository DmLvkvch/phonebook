package com.googleservice.ews.email.google.service;

import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.dmlvkvch.oauth.domain.User;
import com.dmlvkvch.oauth.service.OAuthService;


import java.net.URI;
import java.util.Map;

public interface GoogleOAuthService extends OAuthService {

    @Override
    URI getOAuthUri();

    @Override
    AccessToken getAccessToken(Map<String, String> authCode);

    @Override
    void saveAccessToken(User user, AccessToken accessToken);

    @Override
    void updateAccessToken(User user, AccessToken accessToken);

    @Override
    void deleteAccessToken(User user, AccessToken accessToken);
}
