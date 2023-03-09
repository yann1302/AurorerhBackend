package com.advance.aurore_rh.dto.request;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.NoteProfessionel;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class NoteProfessionelRequestDTO {
    private Long id;

    private String theme;

    private String description;

    private Date date_publication;

    private List<EmployerRequestDTO> employers;

    public static NoteProfessionel buildFromDto(NoteProfessionelRequestDTO dto){
        return NoteProfessionel.NoteProfessionelBuilder.aNoteProfessionel()
                .theme(dto.getTheme())
                .description((dto.getDescription()))
                .date_publication(dto.getDate_publication())

                .build();
    }
}
