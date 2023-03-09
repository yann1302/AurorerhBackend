package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.model.NoteProfessionel;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class NoteProfessionelResponseDTO {
    private Long id;

    private String theme;

    private String description;

    private Date date_publication;

    private List<EmployerRequestDTO> employers;

    public static NoteProfessionelResponseDTO buildFromEntity(NoteProfessionel entity){
      return   NoteProfessionelResponseDTO.builder()
                .id(entity.getId())
                .theme(entity.getTheme())
                .date_publication(entity.getDate_publication())
                .description(entity.getDescription())
                .build();


    }
}
