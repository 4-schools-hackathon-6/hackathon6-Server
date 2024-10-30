package com.hackathon.server.domain.reservation.presentation.dto.request;

import com.hackathon.server.domain.reservation.entity.ReservationType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MakeReservationRequestDto {
    private String day;
    private String time;
    private Boolean repetition;
    private Float x;
    private Float y;
    private ReservationType type;
}
