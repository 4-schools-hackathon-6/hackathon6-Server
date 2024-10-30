package com.hackathon.server.domain.location.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetLocationResponseDto {
    private Float x;
    private Float y;
}
