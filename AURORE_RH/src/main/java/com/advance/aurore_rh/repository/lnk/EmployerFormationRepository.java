package com.advance.aurore_rh.repository.lnk;

import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerFormationRepository extends JpaRepository<EmployerFormation, Long> {

 List <EmployerFormation> findByReference(String reference );

 String deleteByReference(String reference);
}
