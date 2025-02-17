package com.hackathon.server.domain.call.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AcceptRequest {
    private Long acceptedUserId;
    private Long callId;
}
