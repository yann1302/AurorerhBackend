package com.advance.aurore_rh.dto.response;


import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.TypeContrat;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class TypeContratResponseDTO {
    private Long id;

    private String typecontrat;

    private String description;

    public static TypeContratResponseDTO buildFromEntity(TypeContrat entity){
        return TypeContratResponseDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .typecontrat(entity.getTypecontrat())
                .build();
    }


    public static List<TypeContratResponseDTO> buildFromEntityList(List<TypeContrat> typeContratList){
        return  typeContratList.stream().map(TypeContratResponseDTO::buildFromEntity).collect(Collectors.toList());
    }
}
