package com.advance.aurore_rh.repository;

import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Employer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CongerRepository extends JpaRepository <Conger, Long>{
    boolean existsByEmployerId(Long idEmployer);
    String deleteByEmployerId(Long id);

    @Query("SELECT e FROM Conger e " +
            "WHERE (e.type_conger like :token  or e.employer.nom like :token or e.employer.prenom like :token or e.statut like :token)"
    )
    Page<Conger> findAllByToken(String token, Pageable pageable);
}
