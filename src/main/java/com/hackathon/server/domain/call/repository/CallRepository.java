package com.hackathon.server.domain.call.repository;

import com.hackathon.server.domain.call.domain.Calls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallRepository extends JpaRepository<Calls, Long> {
}
