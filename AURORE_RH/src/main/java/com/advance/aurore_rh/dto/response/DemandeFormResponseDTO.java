package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.model.DemandeForm;
import com.advance.aurore_rh.model.Employer;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class DemandeFormResponseDTO {
    private long id;
    private Date date_demande;
    private String Statut;
    private EmployerResponseDTO employerResponseDTO;
    private FormationResponseDTO formationResponseDTO;

    public static DemandeFormResponseDTO buildFromEntity(DemandeForm entity){
        return DemandeFormResponseDTO.builder()
                .id(entity.getId())
                .date_demande(entity.getDate_demande())
                .Statut(entity.getStatut())
                .employerResponseDTO(EmployerResponseDTO.buildFromEntity(entity.getEmployer()))
                .formationResponseDTO(FormationResponseDTO.buildFromEntity(entity.getFormation()))
                .build();
    }


    public static List<DemandeFormResponseDTO> buildFromEntity(List <DemandeForm> demandeFormList){
        return demandeFormList.stream().map(DemandeFormResponseDTO::buildFromEntity).collect(Collectors.toList());
    }

}
