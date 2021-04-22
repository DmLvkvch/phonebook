package com.dmlvkvch.oauth.dto;

import com.dmlvkvch.oauth.domain.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessTokenDto {

    private String accessToken;

    private String refreshToken;

    private String tokenType;

    private Long expiresInSeconds;

    private ServiceType serviceType;
}
