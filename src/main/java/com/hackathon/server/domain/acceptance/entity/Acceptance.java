package com.hackathon.server.domain.acceptance.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "swing_acceptance", timeToLive = 60 * 30)
@Builder
@Getter
public class Acceptance {
    @Id
    private Long userId;

    private Float x;

    private Float y;

    private Float radius;
}
