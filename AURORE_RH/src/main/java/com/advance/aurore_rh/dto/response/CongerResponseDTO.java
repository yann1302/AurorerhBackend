package com.advance.aurore_rh.dto.response;


import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.model.Employer;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder

public class CongerResponseDTO {
    private Long id ;
    private String date_debut;
    private String date_fin;
    private String type_conger;
    private String validation;
    private String statut;
    private String description;
    private String date_reprise;
    private Date etablissement_conger;
    private long jours;
    private long dureeMatern;
    private String dateDebutMatern;
    private String dateFinMatern;
    private EmployerResponseDTO employerResponseDTO;
    public List<ContratResponseDTO> contrats;

        public static CongerResponseDTO buildFromEntity(Conger entity){
            return  CongerResponseDTO.builder()
                    .id(entity.getId())
                    .etablissement_conger(entity.getEtablissement_conger())
                    .date_debut(entity.getDate_debut())
                    .date_fin(entity.getDate_fin())
                    .type_conger(entity.getType_conger())
                    .validation(entity.getValidation())
                    .statut(entity.getStatut())
                    .date_reprise(entity.getDate_reprise())
                    .description(entity.getDescription())
                    .jours(entity.getJours())
                    .dureeMatern(entity.getDureeMatern())
                    .dateDebutMatern(entity.getDateDebutMatern())
                    .dateFinMatern(entity.getDateFinMatern())
                    .employerResponseDTO(EmployerResponseDTO.buildFromEntity((entity.getEmployer())))
                    .build();
        }

    public static CongerResponseDTO buildFromEntityCon(Conger entity, List<Contrat> contratList){
        return  CongerResponseDTO.builder()
                .id(entity.getId())
                .etablissement_conger(entity.getEtablissement_conger())
                .date_debut(entity.getDate_debut())
                .date_fin(entity.getDate_fin())
                .type_conger(entity.getType_conger())
                .validation(entity.getValidation())
                .statut(entity.getStatut())
                .date_reprise(entity.getDate_reprise())
                .description(entity.getDescription())
                .jours(entity.getJours())
                .employerResponseDTO(EmployerResponseDTO.buildFromEntity((entity.getEmployer())))
                .contrats(ContratResponseDTO.buildFromEntity(contratList))
                .build();
    }

    public static List<CongerResponseDTO> buildFromEntity(List<Conger> congerList){
        return congerList.stream().map(CongerResponseDTO::buildFromEntity).collect(Collectors.toList());
    }

    public static Page<CongerResponseDTO> buildFromEntityPage(Page<Conger> entityList) {
        return entityList.map(CongerResponseDTO::buildFromEntity);
    }

    public static CongerResponseDTO buildFromEntity(Optional<Conger> byId) {
            return byId.map(CongerResponseDTO::buildFromEntity).get();
    }
}
