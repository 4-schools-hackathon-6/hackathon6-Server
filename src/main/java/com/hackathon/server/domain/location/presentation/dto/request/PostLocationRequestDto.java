package com.hackathon.server.domain.location.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostLocationRequestDto {
    private Float x;
    private Float y;
}
