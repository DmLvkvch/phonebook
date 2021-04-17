package com.dmlvkvch.oauth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    @JsonManagedReference
    @JsonIgnore
    private List<OAuth2UserAccessCredential> oAuth2UserAccessCredentialList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    @JsonManagedReference
    @JsonIgnore
    private List<UserServiceInfo> userServiceInfoList;

    public User(List<OAuth2UserAccessCredential> oAuth2UserAccessCredentialList) {
        this.oAuth2UserAccessCredentialList = oAuth2UserAccessCredentialList;
    }

    public User(List<OAuth2UserAccessCredential> oAuth2UserAccessCredentialList, List<UserServiceInfo> userServiceInfoList) {
        this.oAuth2UserAccessCredentialList = oAuth2UserAccessCredentialList;
        this.userServiceInfoList = userServiceInfoList;
    }
}
