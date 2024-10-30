package com.hackathon.server.domain.location.service;

import com.hackathon.server.domain.location.entity.Location;
import com.hackathon.server.domain.location.presentation.dto.request.PostLocationRequestDto;
import com.hackathon.server.domain.location.repository.LocationRepository;
import com.hackathon.server.domain.user.entity.User;
import com.hackathon.server.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class PostLocationService {

    private final UserUtil userUtil;
    private final LocationRepository locationRepository;

    public void execute(PostLocationRequestDto postLocationRequestDto) {
        User user = userUtil.getCurrentUser();

        saveLocation(postLocationRequestDto, user);
    }

    private void saveLocation(PostLocationRequestDto postLocationRequestDto, User user) {
        Location location = Location.builder()
                .x(postLocationRequestDto.getX())
                .y(postLocationRequestDto.getY())
                .user(user)
                .build();

        locationRepository.save(location);
    }
}
