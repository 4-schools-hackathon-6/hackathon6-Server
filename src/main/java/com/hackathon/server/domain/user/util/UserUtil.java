package com.hackathon.server.domain.user.util;

import com.hackathon.server.domain.user.entity.User;
import com.hackathon.server.domain.user.repository.UserRepository;
import com.hackathon.server.global.exception.BusinessException;
import com.hackathon.server.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtil {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));
    }

}
