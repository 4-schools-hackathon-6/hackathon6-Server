package com.hackathon.server.domain.reservation.presentation;

import com.hackathon.server.domain.reservation.presentation.dto.request.MakeReservationRequestDto;
import com.hackathon.server.domain.reservation.service.MakeReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final MakeReservationService makeReservationService;

    @PostMapping
    public ResponseEntity<Void> makeReservation(@RequestBody MakeReservationRequestDto makeReservationRequestDto) {
        makeReservationService.execute(makeReservationRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
