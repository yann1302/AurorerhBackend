package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class FormationResponseDTO {
    private Long id;

    private String theme_form;

    private Date debut_form;

    private Date fin_form;

    private String description;

    public  static FormationResponseDTO buildFromEntity(Formation entity) {
        return FormationResponseDTO.builder()
                .id(entity.getId())
                .theme_form(entity.getTheme_form())
                .build();

    }
}