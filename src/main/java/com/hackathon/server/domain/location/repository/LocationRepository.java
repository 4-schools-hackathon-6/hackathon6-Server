package com.hackathon.server.domain.location.repository;

import com.hackathon.server.domain.location.entity.Location;
import com.hackathon.server.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByUser(User user);
}
