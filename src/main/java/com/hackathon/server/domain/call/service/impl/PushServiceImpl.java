package com.hackathon.server.domain.call.service.impl;

import com.hackathon.server.domain.call.domain.Calls;
import com.hackathon.server.domain.call.presentation.dto.response.PushScallReponse;
import com.hackathon.server.domain.call.repository.CallRepository;
import com.hackathon.server.domain.call.service.PushService;
import com.hackathon.server.domain.user.entity.User;
import com.hackathon.server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class, readOnly = true)
public class PushServiceImpl implements PushService {

    private final UserRepository userRepository;

    public PushScallReponse execute() {
        List<User> users = userRepository.findAll();

        User user = users.get(1);

        return PushScallReponse.builder()
                .userId(user.getId())
                .build();
    }
}
