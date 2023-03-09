package com.advance.aurore_rh.dto.response;


import com.advance.aurore_rh.model.TypeConger;
import com.advance.aurore_rh.model.TypeContrat;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder


public class TypeCongerResponseDTO {

    private Long id;
    private String type_conger;
    private String description;

    public static TypeCongerResponseDTO buildFromEntity(TypeConger entity){
        return TypeCongerResponseDTO.builder()
                .id(entity.getId())
                .type_conger(entity.getType_conger())
                .description(entity.getDescription())
                .build();
    }

    public static List<TypeCongerResponseDTO> buildFromEntityList(List<TypeConger> typeCongerList){
        return  typeCongerList.stream().map(TypeCongerResponseDTO::buildFromEntity).collect(Collectors.toList());
    }
}
