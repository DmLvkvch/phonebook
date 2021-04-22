package com.dmlvkvch.oauth.authenticate;

import com.dmlvkvch.oauth.domain.ServiceType;

public interface AccessToken {
    String getAccessToken();

    String getRefreshToken();

    Long getExpiresInSeconds();

    String getTokenType();

    ServiceType getServiceTokenType();

    String getScope();
}
