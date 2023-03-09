package com.advance.aurore_rh.dto.request;


import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.model.Employer;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.util.Date;

@Data
@Builder

public class ContratRequestDTO {
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

    private Long id_Employer;


    public static Contrat buildFromDto(ContratRequestDTO dto, Employer employer){
       return Contrat.ContratBuilder.aContrat()
               .nom(dto.getNom())
               .prenom(dto.getPrenom())
               .date_embauche(dto.getDate_embauche())
               .lieu_recrutememnt(dto.getLieu_recrutememnt())
               .etat_civil(dto.getEtat_civil())
               .periode_essaie(dto.getPeriode_essaie())
               .lieu_travail(dto.getLieu_travail())
               .type_contrat(dto.getType_contrat())
               .poste(dto.getPoste())
               .Salaire_brut(dto.getSalaire_brut())
               .debut_periode_essaie(dto.getDebut_periode_essaie())
               .fin_periode_essaie(dto.getDate_embauche())
               .statut(dto.getStatut())
               .employer(employer)

               .build();
    }
}
