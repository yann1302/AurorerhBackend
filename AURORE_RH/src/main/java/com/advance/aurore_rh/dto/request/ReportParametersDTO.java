package com.advance.aurore_rh.dto.request;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class ReportParametersDTO {

    @NotNull
    Boolean exporter;

    private long idEtat;
/*

    @ApiModelProperty(dataType = "Long", name = "idWindow", value = "L'id de la fenêtre courante",required = true)
    private Long idWindows;

    @ApiModelProperty(dataType = "String", name = "entity", value = "L'entité ou la table sur laquelle on veut faire une requête. Elle doit être identique à celle de la BD Sage", required = true)
    private String entity;
*/

    List<ParamEtatDTO> paramEtats;

    /**
     * The Filters.
     *//*
    @ApiModelProperty(dataType = "List<UniversalFilter>", name = "filters", value = "Liste de filtre à appliquer pour la requête", allowEmptyValue = true)
    List<UniversalFilter>  filters = new ArrayList<>();
*/
}
