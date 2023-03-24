package com.advance.aurore_rh.repository;

import com.advance.aurore_rh.model.DemandeForm;
import com.advance.aurore_rh.model.Formation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FormationRepository extends JpaRepository<Formation,Long> {
    @Query("SELECT e FROM Formation e " +
            "WHERE ( e.theme_form like :token  )"
    )
    Page<Formation> findAllByToken(String token, Pageable pageable);
}
