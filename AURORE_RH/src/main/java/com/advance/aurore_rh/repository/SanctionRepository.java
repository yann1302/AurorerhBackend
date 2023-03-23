package com.advance.aurore_rh.repository;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Sanction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface  SanctionRepository extends JpaRepository <Sanction, Long> {
    boolean existsByEmployerId(Long idEmployer);
    String deleteByEmployerId(Long id);


    @Query("SELECT e FROM Sanction e " +
            "WHERE (e.type_sanction like :token )")
    Page<Sanction> findAllByToken(String token, Pageable pageable);


}
