package com.advance.aurore_rh.dto.response;

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
    private String Formateur;
    private String description;
    private EmployerResponseDTO employerResponseDTO;
    private FormationResponseDTO formationResponseDTO;

    public static EmployerFormationResponseDTO buildFromEntity(EmployerFormation entity){
        return EmployerFormationResponseDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .debut_form(entity.getDebut_form())
                .fin_form(entity.getFin_form())
                .Formateur(entity.getFormateur())
                .employerResponseDTO(EmployerResponseDTO.buildFromEntity(entity.getEmployer()))
                .formationResponseDTO(FormationResponseDTO.buildFromEntity(entity.getFormation()))
                .build();
    }

    public static List<EmployerFormationResponseDTO> buildFromEntity(List <EmployerFormation> employerFormationList){
        return employerFormationList.stream().map(EmployerFormationResponseDTO::buildFromEntity).collect(Collectors.toList());
    }
}
