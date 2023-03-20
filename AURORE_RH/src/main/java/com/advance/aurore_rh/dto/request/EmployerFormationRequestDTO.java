package com.advance.aurore_rh.dto.request;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EmployerFormationRequestDTO {
    private Long id;
    private Date debut_form;
    private Date fin_form;
    private String Formateur;
    private String description;
    private Long employer_id;
    private Long formation_id;

    public static EmployerFormation buildFromDto(EmployerFormationRequestDTO dto, Employer employer, Formation formation){
        return EmployerFormation.EmployerFormationBuilder.anEmployerFormation()
                .description(dto.getDescription())
                .debut_form(dto.getDebut_form())
                .fin_form(dto.getFin_form())
                .Formateur(dto.getFormateur())
                .employer(employer)
                .formation(formation)
                .build();
    }

}

