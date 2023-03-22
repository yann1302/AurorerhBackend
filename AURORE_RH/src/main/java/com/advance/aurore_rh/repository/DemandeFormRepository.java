package com.advance.aurore_rh.repository;

import com.advance.aurore_rh.model.DemandeForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeFormRepository extends JpaRepository <DemandeForm, Long> {

    boolean existsByFormationId(Long formation_Id);
    String deleteByFormationId(Long id);
}
