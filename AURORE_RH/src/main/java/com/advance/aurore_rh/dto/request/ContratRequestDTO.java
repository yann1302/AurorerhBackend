package com.advance.aurore_rh.dto.request;


import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.model.Employer;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import java.util.Date;

@Data
@Builder

public class ContratRequestDTO {
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
    @Enumerated(EnumType.STRING)
    private String statut;
    private String liste_diplo;
    private String document;
    private Long id_Employer;
    private String debut_essaie;
    private String fin_essaie;
    private Long congerAnnuel;


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
               .liste_diplo(dto.getListe_diplo())
               .document(dto.getDocument())
               .employer(employer)
               .debut_essaie(dto.getDebut_essaie())
               .fin_essaie(dto.getFin_essaie())
               .congerAnnuel(dto.getCongerAnnuel())
               .build();
    }
}
