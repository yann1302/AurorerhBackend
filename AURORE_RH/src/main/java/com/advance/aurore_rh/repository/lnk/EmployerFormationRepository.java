package com.advance.aurore_rh.repository.lnk;

import com.advance.aurore_rh.dto.response.EmployerFormationResponseDTO;
import com.advance.aurore_rh.dto.response.SessionsFormationResponseDTO;
import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerFormationRepository extends JpaRepository<EmployerFormation, Long> {

 List <EmployerFormation> findByReference(String reference);

 List <EmployerFormation> findAll( );

  boolean existsByFormationId(Long formation_Id);
 String deleteByFormationId(Long id);

 String deleteByReference(String reference);

// @Query("SELECT ef.formation, COUNT(ef.employer) FROM EmployerFormation ef GROUP BY ef.formation")
// List<EmployerFormationResponseDTO> countEmployersPerFormation();

// @Query( value="SELECT reference,description,debut_form,fin_form,theme_form,formateur, " +
//         "COUNT(reference) AS total_employe " +
//         "FROM lnk_employer_formation " +
//         "GROUP BY  reference,description,debut_form,fin_form,theme_form,formateur", nativeQuery = true)
// List<?> countEmployersPerFormation1();

 @Query("SELECT new com.advance.aurore_rh.dto.response.SessionsFormationResponseDTO(ef.reference,ef.description,ef.debut_form,ef.fin_form,ef.themeForm,ef.formateur,COUNT(reference) )  " +
         //"COUNT(reference) AS total_employe " +
         "FROM EmployerFormation  ef " +
         "GROUP BY  ef.reference,ef.description,ef.debut_form,ef.fin_form,ef.themeForm,ef.formateur")

 List<SessionsFormationResponseDTO> countEmployersPerFormation1();


// @Query("SELECT new com.advance.aurore_rh.dto.response.EmployerFormationResponseDTO(ef.reference, ef.description, ef.debut_form, ef.fin_form,ef.themeForm, ef.formateur) \n" +
//         "FROM EmployerFormation ef \n"
//         //"GROUP BY ef.reference,ef.description, ef.debut_form, ef.fin_form,ef.themeForm, ef.formateur"
// )
// List<EmployerFormationResponseDTO> countEmployersPerFormationV1();

}
