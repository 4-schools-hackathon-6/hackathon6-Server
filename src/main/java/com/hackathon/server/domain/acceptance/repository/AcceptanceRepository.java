package com.hackathon.server.domain.acceptance.repository;

import com.hackathon.server.domain.acceptance.entity.Acceptance;
import org.springframework.data.repository.CrudRepository;

public interface AcceptanceRepository extends CrudRepository<Acceptance, Long> {
}
