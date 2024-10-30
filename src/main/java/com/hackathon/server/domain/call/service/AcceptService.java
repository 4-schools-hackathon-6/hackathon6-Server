package com.hackathon.server.domain.call.service;

import com.hackathon.server.domain.call.presentation.dto.request.AcceptRequest;

public interface AcceptService {
    void execute(AcceptRequest acceptRequest);
}
