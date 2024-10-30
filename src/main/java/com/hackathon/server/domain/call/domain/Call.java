package com.hackathon.server.domain.call.domain;

import com.hackathon.server.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;

    private String time;

    private Float x;

    private Float y;

    private Float radius;

    @Enumerated(EnumType.STRING)
    private CallType type;

    @ManyToOne
    @JoinColumn
    private User user;
}
