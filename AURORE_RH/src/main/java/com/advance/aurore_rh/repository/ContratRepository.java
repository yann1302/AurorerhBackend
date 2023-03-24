package com.advance.aurore_rh.repository;

import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Contrat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContratRepository extends JpaRepository <Contrat, Long> {
    boolean existsByEmployerId(Long idEmployer);
    String deleteByEmployerId(Long id);

    @Query("SELECT e FROM Contrat e " +
            "WHERE (e.type_contrat like :token or e.employer.nom like :token or e.employer.prenom like :token or e.poste like :token or e.statut like :token )"
    )
    Page<Contrat> findAllByToken(String token, Pageable pageable);
}
