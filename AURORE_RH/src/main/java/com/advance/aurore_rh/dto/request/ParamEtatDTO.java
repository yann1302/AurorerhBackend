package com.advance.aurore_rh.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ParamEtatDTO {

    private String texte;
    private Object valeur;

}
