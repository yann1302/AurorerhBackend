package com.advance.aurore_rh.dto.request;


import com.advance.aurore_rh.model.TypeContrat;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class TypeContratRequestDTO {

    private Long id;

    private String typecontrat;

    private String description;


    public static TypeContrat buildFromDTO(TypeContratRequestDTO dto){
        return TypeContrat.TypeContratBuilder.aTypeContrat()
                .type_contrat(dto.getTypecontrat())
                .description(dto.getDescription())
                .build();
    }

}
