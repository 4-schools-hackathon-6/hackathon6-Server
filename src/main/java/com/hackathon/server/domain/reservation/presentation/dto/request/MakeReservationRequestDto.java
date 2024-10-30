package com.hackathon.server.domain.reservation.presentation.dto.request;

import com.hackathon.server.domain.reservation.entity.Kind;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MakeReservationRequestDto {
    private String day;
    private String time;
    private Boolean repetition;
    private String x;
    private String y;
    private Kind kind;
}
