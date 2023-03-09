package com.advance.aurore_rh.dto.request;

import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Employer;
import lombok.Builder;
import lombok.Data;


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

    private String description;

    private Long id_Employer;

    public static Conger buildFromDto(CongerRequestDTO dto, Employer employer){
        return Conger.CongerBuilder.aConger()
                .etablissement_conger(dto.getEtablissement_conger())
                .description(dto.getDescription())
                .date_debut(dto.getDate_debut())
                .date_fin(dto.getDate_fin())
                .date_reprise(dto.getDate_reprise())
                .employer(employer)
                .build();
    }
}
