package com.advance.aurore_rh.dto.request;

import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.model.Employer;
import lombok.Builder;
import lombok.Data;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

@Data
@Builder

public class CongerRequestDTO {
    private Long id ;
    private String date_debut;
    private String date_fin;
    private String type_conger;
    private String date_reprise;
    private Date etablissement_conger;
    private String validation;
    @Enumerated(EnumType.STRING)
    private String statut;
    private String description;
    private long jours;
    private Long id_Employer;
    private List<Contrat> contrats;
    private long dureeMatern;
    private String dateDebutMatern;
    private String dateFinMatern;

    public static Conger buildFromDto(CongerRequestDTO dto, Employer employer){
        return Conger.CongerBuilder.aConger()
                .etablissement_conger(dto.getEtablissement_conger())
                .description(dto.getDescription())
                .date_debut(dto.getDate_debut())
                .type_conger(dto.getType_conger())
                .date_fin(dto.getDate_fin())
                .validation(dto.getValidation())
                .statut((dto.getStatut()))
                .date_reprise(dto.getDate_reprise())
                .jours(dto.getJours())
                .employer(employer)
                .dureeMatern(dto.getDureeMatern())
                .dateDebutMatern(dto.getDateDebutMatern())
                .dateFinMatern(dto.getDateFinMatern())
                .build();
    }
}
