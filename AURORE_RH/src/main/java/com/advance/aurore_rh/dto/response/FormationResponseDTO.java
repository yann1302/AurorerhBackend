package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FormationResponseDTO {
    private Long id;
    private String theme_form;
    private String description;
    private String duree;
    private List<EmployerFormation> employerFormations;

    public  static FormationResponseDTO buildFromEntity(Formation entity) {
        return FormationResponseDTO.builder()
                .id(entity.getId())
                .theme_form(entity.getTheme_form())
                .description(entity.getDescription())
                .duree(entity.getDuree())
                .employerFormations(entity.getEmployerFormations())
                .build();
    }

    public static List <FormationResponseDTO> builFromEntityList(List <Formation> formationList){
        return formationList.stream().map(FormationResponseDTO::buildFromEntity).collect(Collectors.toList());
    }
}