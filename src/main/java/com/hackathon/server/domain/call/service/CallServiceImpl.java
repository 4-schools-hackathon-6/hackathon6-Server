package com.hackathon.server.domain.call.service;

import com.hackathon.server.domain.call.domain.Calls;
import com.hackathon.server.domain.call.presentation.dto.request.CallRequest;
import com.hackathon.server.domain.call.repository.CallRepository;
import com.hackathon.server.domain.user.entity.User;
import com.hackathon.server.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CallServiceImpl implements CallService {

    private final CallRepository callRepository;
    private final UserUtil userUtil;

    public void execute(CallRequest callRequest) {
        User user = userUtil.getCurrentUser();

        saveReservation(user, callRequest);
    }

    private void saveReservation(User user, CallRequest dto) {
        Calls calls = Calls.builder()
                .day(dto.getDay())
                .time(dto.getTime())
                .x(dto.getX())
                .y(dto.getY())
                .radius(dto.getRadius())
                .type(dto.getType())
                .user(user)
                .build();

        callRepository.save(calls);
    }
}
