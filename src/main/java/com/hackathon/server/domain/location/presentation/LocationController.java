package com.hackathon.server.domain.location.presentation;

import com.hackathon.server.domain.location.presentation.dto.request.PostLocationRequestDto;
import com.hackathon.server.domain.location.presentation.dto.response.GetLocationResponseDto;
import com.hackathon.server.domain.location.service.GetLocationService;
import com.hackathon.server.domain.location.service.PostLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/location")
public class LocationController {

    private final GetLocationService getLocationService;
    private final PostLocationService postLocationService;

    @GetMapping
    public ResponseEntity<GetLocationResponseDto> getLocation() {
        return ResponseEntity.ok(getLocationService.execute());
    }

    @PostMapping
    public ResponseEntity<Void> postLocation(@RequestBody PostLocationRequestDto postLocationRequestDto) {
        postLocationService.execute(postLocationRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
