package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
public class EmployerFormationResponseDTO {
    private Long id;
    private Date debut_form;
    private Date fin_form;
    private String formateur;
    private String description;
    private List<EmployerResponseDTO> employerResponseDTO;
    private FormationResponseDTO formationResponseDTO;
    private String reference;
    private String themeForm;

    public static EmployerFormationResponseDTO buildFromEntity(EmployerFormation entity, List <Employer> employerList){
        return EmployerFormationResponseDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .debut_form(entity.getDebut_form())
                .fin_form(entity.getFin_form())
                .formateur(entity.getFormateur())
                .employerResponseDTO(EmployerResponseDTO.builFromEntityList(employerList))
                .formationResponseDTO(FormationResponseDTO.buildFromEntity(entity.getFormation()))
                .themeForm(entity.getThemeForm())
                .reference(entity.getReference())
                .build();
    }



}
