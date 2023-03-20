package com.advance.aurore_rh.dto.request;

import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Employer;
import lombok.Builder;
import lombok.Data;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
@Builder

public class CongerRequestDTO {
    private Long id ;
    private Date date_debut;
    private Date date_fin;
    private String type_conger;
    private Date date_reprise;
    private Date etablissement_conger;
    private String validation;
    @Enumerated(EnumType.STRING)
    private String statut;
    private String description;
    private long jours;
    private Long id_Employer;


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
                .build();
    }
}
