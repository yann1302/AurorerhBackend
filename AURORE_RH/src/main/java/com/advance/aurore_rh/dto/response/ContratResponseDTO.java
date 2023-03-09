package com.advance.aurore_rh.dto.response;


import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.model.Employer;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder

public class ContratResponseDTO {

    private Long id;

    private String nom;

    private String prenom;

    private String lieu_recrutememnt;

    private Date date_embauche;

    private String periode_essaie;

    private Date debut_periode_essaie;

    private Date fin_periode_essaie;

    private String type_contrat;

    private String poste;

    private String lieu_travail;

    private String Salaire_brut;

    private String etat_civil;

    private String statut;

    private EmployerResponseDTO employerResponseDTO;

    public static ContratResponseDTO buildFromEntity(Contrat entity){
        return ContratResponseDTO.builder()
                .id(entity.getId_contrat())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .date_embauche(entity.getDate_embauche())
                .lieu_recrutememnt(entity.getLieu_recrutememnt())
                .etat_civil(entity.getEtat_civil())
                .periode_essaie(entity.getPeriode_essaie())
                .lieu_travail(entity.getLieu_travail())
                .type_contrat(entity.getType_contrat())
                .poste(entity.getPoste())
                .Salaire_brut(entity.getSalaire_brut())
                .debut_periode_essaie(entity.getDebut_periode_essaie())
                .fin_periode_essaie(entity.getDate_embauche())
                .statut(entity.getStatut())
                .employerResponseDTO(EmployerResponseDTO.buildFromEntity(entity.getEmployer()))
                .build();
    }

    public static List<ContratResponseDTO> buildFromEntity(List <Contrat> contratList){
        return contratList.stream().map(ContratResponseDTO::buildFromEntity).collect(Collectors.toList());
    }


}
