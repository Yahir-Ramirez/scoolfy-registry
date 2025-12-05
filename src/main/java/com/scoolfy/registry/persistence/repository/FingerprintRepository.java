package com.scoolfy.registry.persistence.repository;

import com.scoolfy.registry.persistence.entity.Fingerprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FingerprintRepository extends JpaRepository<Fingerprint, Long> {
}