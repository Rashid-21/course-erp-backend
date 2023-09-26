package com.company.courseerpbackend.services.security;

import com.company.courseerpbackend.models.payload.auth.LoginPayload;
import com.company.courseerpbackend.models.payload.auth.RefreshTokenPayload;
import com.company.courseerpbackend.models.response.auth.LoginResponse;

public interface AuthBusinessService {

    LoginResponse login(LoginPayload payload);

    LoginResponse refresh(RefreshTokenPayload payload);

    void logout();

    void setAuthentication(String email);

}
