package com.hackathon.server.domain.call.service;

import com.hackathon.server.domain.call.presentation.dto.response.ScanScallResponse;

import java.util.List;

public interface ScanScallService {
    List<ScanScallResponse> execute(Long callId);
}
