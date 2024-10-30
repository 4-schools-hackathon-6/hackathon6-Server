package com.hackathon.server.domain.call.service.impl;

import com.hackathon.server.domain.acceptance.entity.Acceptance;
import com.hackathon.server.domain.acceptance.repository.AcceptanceRepository;
import com.hackathon.server.domain.call.domain.Calls;
import com.hackathon.server.domain.call.presentation.dto.request.AcceptRequest;
import com.hackathon.server.domain.call.repository.CallRepository;
import com.hackathon.server.domain.call.service.AcceptService;
import com.hackathon.server.domain.user.entity.User;
import com.hackathon.server.domain.user.repository.UserRepository;
import com.hackathon.server.global.exception.BusinessException;
import com.hackathon.server.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class AcceptServiceImpl implements AcceptService {

    private final CallRepository callRepository;
    private final AcceptanceRepository acceptanceRepository;
    private final UserRepository userRepository;

    public void execute(AcceptRequest acceptRequest) {
        Calls call = callRepository.findById(acceptRequest.getCallId())
                .orElseThrow(() -> new BusinessException(ErrorCode.CALL_NOT_FOUND));

        User user = userRepository.findById(acceptRequest.getAcceptedUserId())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        saveAcceptance(call, user.getId());
    }

    private void saveAcceptance(Calls call, Long userId) {
        Acceptance acceptance = Acceptance.builder()
                .userId(userId)
                .x(call.getX())
                .y(call.getY())
                .radius(call.getRadius())
                .build();

        acceptanceRepository.save(acceptance);
    }
}
