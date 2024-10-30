package com.hackathon.server.global.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements ErrorProperty {
    EMAIL_BAD_REQUEST(HttpStatus.BAD_REQUEST, "사용중인 이메일 입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾지 못했습니다"),
    LOCATION_NOT_FOUND(HttpStatus.NOT_FOUND, "위치를 찾지 못했습니다.");

    private final HttpStatus status;
    private final String message;
}
