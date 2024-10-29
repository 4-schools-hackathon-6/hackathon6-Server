package com.hackathon.server.domain.user.service;

import com.hackathon.server.global.exception.BusinessException;
import com.hackathon.server.domain.user.request.SignupRequest;

public interface UserService {
    void registerUser(SignupRequest signupRequest) throws BusinessException;
}
