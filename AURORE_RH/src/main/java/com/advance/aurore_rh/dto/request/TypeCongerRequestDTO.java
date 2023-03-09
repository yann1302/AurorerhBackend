package com.advance.aurore_rh.dto.request;

import com.advance.aurore_rh.model.TypeConger;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class TypeCongerRequestDTO {

    private String type_conger;
    private String description;

    public static TypeConger buildFromDto(TypeCongerRequestDTO dto){
        return TypeConger.TypeCongerBuilder.aTypeConger()
                .type_conger(dto.getType_conger())
                .description(dto.getDescription())
                .build();
    }


}
