package com.hackathon.server.domain.reservation.repository;

import com.hackathon.server.domain.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
