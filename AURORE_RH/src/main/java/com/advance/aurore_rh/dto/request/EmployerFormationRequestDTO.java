package com.advance.aurore_rh.dto.request;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class EmployerFormationRequestDTO {
    private Long id;
    private Date debut_form;
    private Date fin_form;
    private String formateur;
    private String description;
    private List <Long> employers;
    private Long formation_id;
    private String themeForm;
    private String reference;

    public static EmployerFormation buildFromDto(EmployerFormationRequestDTO dto, Employer employer, Formation formation){
        return EmployerFormation.EmployerFormationBuilder.anEmployerFormation()
                .description(dto.getDescription())
                .debut_form(dto.getDebut_form())
                .fin_form(dto.getFin_form())
                .formateur(dto.getFormateur())
                .employer(employer)
                .formation(formation)
                .themeForm((dto.getThemeForm()))
                .reference(dto.getReference())
                .build();
    }

}

