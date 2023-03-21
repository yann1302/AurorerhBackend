package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FormationResponseDTO {
    private Long id;
    private String theme_form;
    @Column(length = 500)
    private String description;
    private String duree;
    private Date date_publication;
    private String photo;
   // private EmployerFormationResponseDTO employerFormationResponseDTO;

    public  static FormationResponseDTO buildFromEntity(Formation entity) {
        return FormationResponseDTO.builder()
                .id(entity.getId())
                .theme_form(entity.getTheme_form())
                .description(entity.getDescription())
                .duree(entity.getDuree())
                .photo(entity.getPhoto())
                .date_publication(entity.getDate_publication())
                //.employerFormationResponseDTO(EmployerFormationResponseDTO.buildFromEntity(entity.getEmployerFormations()))
                .build();
    }

    public static List <FormationResponseDTO> builFromEntityList(List <Formation> formationList){
        return formationList.stream().map(FormationResponseDTO::buildFromEntity).collect(Collectors.toList());
    }
}