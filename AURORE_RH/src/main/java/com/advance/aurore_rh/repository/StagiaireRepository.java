package com.advance.aurore_rh.repository;


import com.advance.aurore_rh.model.Stagiaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
    Boolean existsByCodeStage(String codeStage);
}
