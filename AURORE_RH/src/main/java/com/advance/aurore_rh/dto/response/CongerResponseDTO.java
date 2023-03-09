package com.advance.aurore_rh.dto.response;


import com.advance.aurore_rh.model.Conger;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder

public class CongerResponseDTO {
    private Long id ;

    private Date date_debut;

    private Date date_fin;

    private String type_conger;

    private String validation;

    private String description;

    private Date date_reprise;

    private Date etablissement_conger;

    private EmployerResponseDTO employerResponseDTO;

        public static CongerResponseDTO buildFromEntity(Conger entity){
            return  CongerResponseDTO.builder()
                    .id(entity.getId())
                    .etablissement_conger(entity.getEtablissement_conger())
                    .date_debut(entity.getDate_debut())
                    .date_fin(entity.getDate_fin())
                    .date_reprise(entity.getDate_reprise())
                    .description(entity.getDescription())
                    .employerResponseDTO(EmployerResponseDTO.buildFromEntity((entity.getEmployer())))
                    .build();
        }

    public static List<CongerResponseDTO> buildFromEntity(List<Conger> congerList){
        return congerList.stream().map(CongerResponseDTO::buildFromEntity).collect(Collectors.toList());
    }

    public static CongerResponseDTO buildFromEntity(Optional<Conger> byId) {
            return byId.map(CongerResponseDTO::buildFromEntity).get();
    }
}
