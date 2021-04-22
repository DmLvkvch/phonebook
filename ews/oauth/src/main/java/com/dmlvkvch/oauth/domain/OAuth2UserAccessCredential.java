package com.dmlvkvch.oauth.domain;

import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OAuth2UserAccessCredential extends AbstractEntity implements Serializable {

    private String accessToken;

    private String refreshToken;

    private String tokenType;

    private Long expiresInSeconds;

    @Enumerated(EnumType.ORDINAL)
    private ServiceType serviceType;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public OAuth2UserAccessCredential(String accessToken, String refreshToken, String tokenType, Long expiresInSeconds, ServiceType serviceType) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
        this.expiresInSeconds = expiresInSeconds;
        this.serviceType = serviceType;
    }

    public OAuth2UserAccessCredential(AccessToken accessToken) {
        this.accessToken = accessToken.getAccessToken();
        this.refreshToken = accessToken.getRefreshToken();
        this.tokenType = accessToken.getTokenType();
        this.expiresInSeconds = accessToken.getExpiresInSeconds();
    }
}
