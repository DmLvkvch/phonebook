package com.dmlvkvch.oauth.authenticate;

import java.net.URI;
import java.util.Map;

public interface OAuth2 {
    URI getAuthenticateUrl();

    AccessToken getAccessToken(Map<String, String> authCodeResponse);
}
