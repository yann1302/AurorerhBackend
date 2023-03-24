package com.advance.aurore_rh.repository;


import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.Stagiaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Long> {
    Boolean existsByCodeStage(String codeStage);

    @Query("SELECT e FROM Stagiaire e " +
            "WHERE ( e.nom like :token or e.prenom like :token  or e.codeStage like :token or e.departement like :token or e.ecole like :token     )"
    )
    Page<Stagiaire> findAllByToken(String token, Pageable pageable);
}
