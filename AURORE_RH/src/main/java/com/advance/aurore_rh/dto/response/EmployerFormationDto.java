package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployerFormationDto {

    private EmployerResponseDTO employer;


    public static EmployerFormationDto buildFromEntity(EmployerFormation entity){
        return EmployerFormationDto.builder()
                .employer(EmployerResponseDTO.buildFromEntity(entity.getEmployer()))
                .build();

    }
}
