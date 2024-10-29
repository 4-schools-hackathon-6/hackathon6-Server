package com.hackathon.server.domain.location.presentation;

import com.hackathon.server.domain.location.presentation.dto.response.GetLocationResponseDto;
import com.hackathon.server.domain.location.service.GetLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {

    private final GetLocationService getLocationService;

    @GetMapping("/{location_id}")
    public ResponseEntity<GetLocationResponseDto> getLocation(@PathVariable("location_id") Long locationId) {
        return ResponseEntity.ok(getLocationService.execute(locationId));
    }
}
