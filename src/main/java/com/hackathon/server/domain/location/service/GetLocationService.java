package com.hackathon.server.domain.location.service;

import com.hackathon.server.domain.location.entity.Location;
import com.hackathon.server.domain.location.presentation.dto.response.GetLocationResponseDto;
import com.hackathon.server.domain.location.repository.LocationRepository;
import com.hackathon.server.domain.user.entity.User;
import com.hackathon.server.domain.user.util.UserUtil;
import com.hackathon.server.global.exception.BusinessException;
import com.hackathon.server.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetLocationService {

    private final LocationRepository locationRepository;
    private final UserUtil userUtil;

    public GetLocationResponseDto execute() {
        User user = userUtil.getCurrentUser();

        Location location = locationRepository.findByUser(user)
                .orElseThrow(() -> new BusinessException(ErrorCode.LOCATION_NOT_FOUND));

        return GetLocationResponseDto.builder()
                .x(location.getX())
                .y(location.getY())
                .build();
    }
}
