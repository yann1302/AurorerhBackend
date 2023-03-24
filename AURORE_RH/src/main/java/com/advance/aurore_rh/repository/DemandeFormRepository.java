package com.advance.aurore_rh.repository;

import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.model.DemandeForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DemandeFormRepository extends JpaRepository <DemandeForm, Long> {

    boolean existsByFormationId(Long formation_Id);
    String deleteByFormationId(Long id);

    @Query("SELECT e FROM DemandeForm e " +
            "WHERE ( e.employer.nom like :token or e.employer.prenom like :token or e.employer.codeEmployer like :token or e.statut like :token  or e.formation.theme_form like :token  )"
    )
    Page<DemandeForm> findAllByToken(String token, Pageable pageable);
}
