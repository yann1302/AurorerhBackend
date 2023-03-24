package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.NoteProfessionel;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class NoteProfessionelResponseDTO {
    private Long id;

    private String theme;

    private String description;

    private String photo;

    private Date date_publication;

    public static NoteProfessionelResponseDTO buildFromEntity(NoteProfessionel entity){
      return   NoteProfessionelResponseDTO.builder()
                .id(entity.getId())
                .theme(entity.getTheme())
                .date_publication(entity.getDate_publication())
                .description(entity.getDescription())
                .photo(entity.getPhoto())
                .build();
    }
    public static List<NoteProfessionelResponseDTO> buildFromEntity(List <NoteProfessionel> NoteProfessionelList){
        return NoteProfessionelList.stream().map(NoteProfessionelResponseDTO::buildFromEntity).collect(Collectors.toList());
    }

    public static Page<NoteProfessionelResponseDTO> buildFromEntityPage(Page<NoteProfessionel> entityList) {
        return entityList.map(NoteProfessionelResponseDTO::buildFromEntity);
    }
}
