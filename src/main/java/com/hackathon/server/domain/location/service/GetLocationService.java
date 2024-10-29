package com.hackathon.server.domain.location.service;

import com.hackathon.server.domain.location.entity.Location;
import com.hackathon.server.domain.location.presentation.dto.response.GetLocationResponseDto;
import com.hackathon.server.domain.location.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetLocationService {

    private final LocationRepository locationRepository;

    public GetLocationResponseDto execute(Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow();

        return GetLocationResponseDto.builder()
                .x(location.getX())
                .y(location.getY())
                .build();
    }
}
