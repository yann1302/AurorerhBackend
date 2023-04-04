package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Sanction;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class SanctionResponseDTO {

    private Long id;
    private String type_sanction;
    private String debut_sanction;
    private String fin_sanction;
    private String description;
    private String statut;
    private EmployerResponseDTO employerResponseDTO;

    public  static SanctionResponseDTO buildFromEntity(Sanction entity){
        return SanctionResponseDTO.builder()
                .id(entity.getId_sanction())
                .description(entity.getDescription())
                .fin_sanction(entity.getFin_sanction())
                .debut_sanction(entity.getDebut_sanction())
                .type_sanction(entity.getType_sanction())
                .statut(entity.getStatut())
                .employerResponseDTO(EmployerResponseDTO.buildFromEntity(entity.getEmployer()))
                .build();
    }


    public static  List<SanctionResponseDTO> buildFromEntityList(List<Sanction> sanctionList){
        return sanctionList.stream().map(SanctionResponseDTO::buildFromEntity).collect(Collectors.toList());
    }

    public static Page<SanctionResponseDTO> buildFromEntityPage(Page<Sanction> entityList) {
        return entityList.map(SanctionResponseDTO::buildFromEntity);
    }


    public static SanctionResponseDTO buildFromEntity(Optional<Sanction> byId) {
        return byId.map(SanctionResponseDTO::buildFromEntity).get();
    }
}
