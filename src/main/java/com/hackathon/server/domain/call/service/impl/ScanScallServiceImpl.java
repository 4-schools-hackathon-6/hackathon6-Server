package com.hackathon.server.domain.call.service.impl;

import com.hackathon.server.domain.call.domain.Calls;
import com.hackathon.server.domain.call.presentation.dto.response.ScanScallResponse;
import com.hackathon.server.domain.call.repository.CallRepository;
import com.hackathon.server.domain.call.service.ScanScallService;
import com.hackathon.server.domain.location.entity.Location;
import com.hackathon.server.domain.location.repository.LocationRepository;
import com.hackathon.server.global.exception.BusinessException;
import com.hackathon.server.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class ScanScallServiceImpl implements ScanScallService {

    private final CallRepository callRepository;
    private final LocationRepository locationRepository;

    public List<ScanScallResponse> execute(Long callId) {
        Map<Long, Double> userByDistance = new HashMap<>();

        Calls call = callRepository.findById(callId)
                .orElseThrow(() -> new BusinessException(ErrorCode.CALL_NOT_FOUND));

        for (Location location : locationRepository.findAll()) {
            Double distance = Math.sqrt(Math.pow((double) location.getX() - (double) call.getX() ,2)) + Math.pow((double) location.getY() - (double) call.getY(), 2);
            userByDistance.put(location.getId(), distance);
        }

        return selectUserForScall(userByDistance);
    }

    private List<ScanScallResponse> selectUserForScall(Map<Long, Double> userByDistance) {
        List<Long> keySet = new ArrayList<>(userByDistance.keySet());

        keySet.sort(Comparator.comparing(userByDistance::get));

        Long[] locationArray = new Long[2];

        for (int i = 0; i <= 1; i++) {
            Long locationId = keySet.get(i);
            locationArray[i] = locationId;
        }

         List<ScanScallResponse> responses = Arrays.stream(locationArray).map(locationId -> {
            Location location  = locationRepository.findById(locationId)
                    .orElseThrow(() -> new BusinessException(ErrorCode.LOCATION_NOT_FOUND));

            return ScanScallResponse.builder()
                    .userId(location.getUser().getId())
                    .build();
        }).toList();

        return responses;
    }
}
