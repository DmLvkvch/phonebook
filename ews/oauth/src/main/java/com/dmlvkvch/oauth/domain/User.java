package com.dmlvkvch.oauth.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User extends AbstractEntity implements Serializable {

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private OAuth2UserAccessCredential oAuth2UserAccessCredential;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private UserServiceInfo userServiceInfo;

    public User(OAuth2UserAccessCredential oAuth2UserAccessCredential, UserServiceInfo userServiceInfo) {
        this.oAuth2UserAccessCredential = oAuth2UserAccessCredential;
        this.userServiceInfo = userServiceInfo;
    }
}
