package com.advance.aurore_rh.repository;

import com.advance.aurore_rh.model.Employer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface EmployerRepository extends JpaRepository <Employer, Long> {

  Boolean existsByCodeEmployer(String codeEmployer);

  List<Employer> findByCodeEmployer(String codeEmployer);

  @Query("SELECT e FROM Employer e " +

          "WHERE (e.nom like :token or e.prenom like:token or e.codeEmployer like:token or e.poste like:token or e.adresse like:token ) " +
          "AND (e.statut = :statut )"
  )
  Page <Employer> findAllByToken(String token,String statut, Pageable pageable);



  String deleteByusername(String username);

}
