package com.advance.aurore_rh.dto.request;

import com.advance.aurore_rh.model.Employer;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EmployerRequestDTO {

    private long id;

    private String nom;

    private String prenom;

    private String photo;

    private Date date_naissance;

    private String lieu_naissance;

    private String statut_matrimoniale;

    private String adresse;

    private long numero;

    private String type_contrat;

    private Date date_debut;

    private  Date date_fin;

    private String ville_exertion;

    private String nationalite;

    private String matricule;

    private String sexe;

    private long nbr_enfant;

    private String profession;

    private String poste;


        public  static Employer buildFromDto(EmployerRequestDTO dto){
            return Employer.EmployerBuilder.anEmployer()
                    .nom(dto.getNom())
                    .prenom(dto.getPrenom())
                    .adresse(dto.getAdresse())
                    .date_naissance(dto.getDate_naissance())
                    .lieu_naissance(dto.getLieu_naissance())
                    .matricule(dto.getMatricule())
                    .photo(dto.getPhoto())
                    .nationalite(dto.getNationalite())
                    .nbr_enfant(dto.getNbr_enfant())
                    .poste(dto.getPoste())
                    .sexe(dto.getSexe())
                    .numero(dto.getNumero())
                    .ville_exertion(dto.getVille_exertion())
                    .type_contrat(dto.getType_contrat())
                    .date_debut(dto.getDate_debut())
                    .date_fin(dto.getDate_fin())
                    .statut_matrimoniale(dto.getStatut_matrimoniale())
                    .profession(dto.getProfession())
                    .build();
        }

}
