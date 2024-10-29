package com.hackathon.server.domain.location.repository;

import com.hackathon.server.domain.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
