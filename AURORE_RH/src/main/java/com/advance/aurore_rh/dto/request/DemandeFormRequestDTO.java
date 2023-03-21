package com.advance.aurore_rh.dto.request;


import com.advance.aurore_rh.model.DemandeForm;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class DemandeFormRequestDTO {

    private long id;
    private Date date_demande;
    private String Statut;
    private Long id_Employer;
    private Long id_Formation;

    public static DemandeForm buildFromDTO(DemandeFormRequestDTO dto, Employer employer, Formation formation){
        return DemandeForm.DemandeFormBuilder.aDemandeForm()
                .date_demande(dto.getDate_demande())
                .statut(dto.getStatut())
                .employer(employer)
                .formation(formation)
                .build();
    }

}
