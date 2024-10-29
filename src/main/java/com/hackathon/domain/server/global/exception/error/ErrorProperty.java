package com.hackathon.domain.server.global.exception.error;

import org.springframework.http.HttpStatus;

public interface ErrorProperty {
    HttpStatus getStatus();
    String getMessage();
}
