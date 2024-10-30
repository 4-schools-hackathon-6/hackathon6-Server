package com.hackathon.server.domain.call.service;

import com.hackathon.server.domain.call.presentation.dto.request.CallRequest;

public interface CallService {
    void execute(CallRequest callRequest);
}
