package com.hackathon.domain.server.domain.user.service;

import com.hackathon.domain.server.global.exception.BusinessException;
import com.hackathon.domain.server.domain.user.request.SignupRequest;

public interface UserService {
    void registerUser(SignupRequest signupRequest) throws BusinessException;
}
