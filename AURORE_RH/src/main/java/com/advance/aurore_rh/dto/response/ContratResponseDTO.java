package com.advance.aurore_rh.dto.response;


import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.model.Employer;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

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
    private String date_embauche;
    private Long periode_essaie;
    private String debut_periode_essaie;
    private String fin_periode_essaie;
    private String type_contrat;
    private String poste;
    private String lieu_travail;
    private String Salaire_brut;
    private String etat_civil;
    private String statut;
    private String liste_diplo;
    private String document;
    private String debut_essaie;
    private String fin_essaie;
    private Long congerAnnuel;
    private int Jours_de_conges_pris;
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
                .liste_diplo(entity.getListe_diplo())
                .document(entity.getDocument())
                .debut_essaie(entity.getDebut_essaie())
                .fin_essaie(entity.getFin_essaie())
                .congerAnnuel(entity.getCongerAnnuel())
                .Jours_de_conges_pris(entity.getJours_de_conges_pris())
                .employerResponseDTO(EmployerResponseDTO.buildFromEntity(entity.getEmployer()))
                .build();
    }

    public static List<ContratResponseDTO> buildFromEntity(List <Contrat> contratList){
        return contratList.stream().map(ContratResponseDTO::buildFromEntity).collect(Collectors.toList());
    }

    public static Page<ContratResponseDTO> buildFromEntityPage(Page<Contrat> entityList) {
        return entityList.map(ContratResponseDTO::buildFromEntity);
    }


}
