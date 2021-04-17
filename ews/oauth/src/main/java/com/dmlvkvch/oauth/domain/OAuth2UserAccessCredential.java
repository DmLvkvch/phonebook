package com.dmlvkvch.oauth.domain;

import com.dmlvkvch.oauth.authenticate.AccessToken;
import com.dmlvkvch.oauth.authenticate.TokenType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OAuth2UserAccessCredential implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String accessToken;

    private String refreshToken;

    private TokenType tokenType;

    private Long expiresInSeconds;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public OAuth2UserAccessCredential(String accessToken, String refreshToken, TokenType tokenType, Long expiresInSeconds) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.tokenType = tokenType;
        this.expiresInSeconds = expiresInSeconds;
    }

    public OAuth2UserAccessCredential(AccessToken accessToken) {
        this.accessToken = accessToken.getAccessToken();
        this.refreshToken = accessToken.getRefreshToken();
        this.tokenType = accessToken.getServiceTokenType();
        this.expiresInSeconds = accessToken.getExpiresInSeconds();
    }
}
