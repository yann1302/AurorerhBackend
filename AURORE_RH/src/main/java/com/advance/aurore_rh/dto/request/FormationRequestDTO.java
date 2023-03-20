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
public class FormationRequestDTO {
    private Long id;

    private String theme_form;
    private String description;
    private String duree;
    //private List<EmployerFormation> employerFormations;

    public static Formation buildFromDto(FormationRequestDTO dto){
        return Formation.FormationBuilder.aFormation()

                .theme_form(dto.getTheme_form())
                .description(dto.getDescription())
                .duree(dto.getDuree())
               // .employerFormations(dto.getEmployerFormations())
                .build();
    }
}
