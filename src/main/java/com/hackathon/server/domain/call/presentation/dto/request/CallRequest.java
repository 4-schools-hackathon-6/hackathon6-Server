package com.hackathon.server.domain.call.presentation.dto.request;

import com.hackathon.server.domain.call.domain.CallType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CallRequest {
    private String day;
    private String time;
    private Float x;
    private Float y;
    private Float radius;
    private CallType type;
}
