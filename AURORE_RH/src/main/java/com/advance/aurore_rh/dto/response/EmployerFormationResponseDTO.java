package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class EmployerFormationResponseDTO {
    private Long id;
    private Date debut_form;
    private Date fin_form;
    private String formateur;
    private String description;
    private List<EmployerResponseDTO> employers;
    private FormationResponseDTO formation;
    private String reference;
    private String themeForm;

    public static EmployerFormationResponseDTO buildFromEntity(EmployerFormation entity, List <Employer> employerList){
        return EmployerFormationResponseDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .debut_form(entity.getDebut_form())
                .fin_form(entity.getFin_form())
                .formateur(entity.getFormateur())
                .employers(EmployerResponseDTO.builFromEntityList(employerList))
                .formation(FormationResponseDTO.buildFromEntity(entity.getFormation()))
                .themeForm(entity.getThemeForm())
                .reference(entity.getReference())
                .build();
    }

//   public static List<EmployerFormationResponseDTO> buildFromEntity(List <EmployerFormation> employerFormationList){
//        return employerFormationList.stream().map(EmployerFormationResponseDTO::buildFromEntity).collect(Collectors.toList());
//    }

}
