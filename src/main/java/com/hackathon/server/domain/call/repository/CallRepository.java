package com.hackathon.server.domain.call.repository;

import com.hackathon.server.domain.call.domain.Call;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallRepository extends JpaRepository<Call, Long> {
}
