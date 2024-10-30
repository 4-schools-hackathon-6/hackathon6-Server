package com.hackathon.server.domain.reservation.service;

import com.hackathon.server.domain.reservation.entity.Reservation;
import com.hackathon.server.domain.reservation.presentation.dto.request.MakeReservationRequestDto;
import com.hackathon.server.domain.reservation.repository.ReservationRepository;
import com.hackathon.server.domain.user.entity.User;
import com.hackathon.server.domain.user.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MakeReservationService {

    private final ReservationRepository reservationRepository;
    private final UserUtil userUtil;

    public void execute(MakeReservationRequestDto makeReservationRequestDto) {
        User user = userUtil.getCurrentUser();

        saveReservation(user, makeReservationRequestDto);
    }

    private void saveReservation(User user, MakeReservationRequestDto dto) {
        Reservation reservation = Reservation.builder()
                .day(dto.getDay())
                .time(dto.getTime())
                .x(dto.getX())
                .y(dto.getY())
                .repetition(dto.getRepetition())
                .type(dto.getType())
                .radius(dto.getRadius())
                .user(user)
                .build();

        reservationRepository.save(reservation);
    }
}
