package com.advance.aurore_rh.repository;

import com.advance.aurore_rh.model.Sanction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  SanctionRepository extends JpaRepository <Sanction, Long> {
    boolean existsByEmployerId(Long idEmployer);
}
