package com.betrybe.agrix.ebytr.staff.repository;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for managing Fertilizer entities.
 */
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

}
