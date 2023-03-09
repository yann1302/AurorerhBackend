package com.advance.aurore_rh.dto.request;

import com.advance.aurore_rh.model.Stagiare;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
@Builder
public class StagiaireRequestDTO {

    private long id;

    private String nom;

    private String prenom;

    private String photo;

    private Date date_naissance;

    private String lieu_naissance;

    private String statut_matrimoniale;

    private String adresse;

    private long numero;

    private String ecole;

    private Date date_debut;

    private  Date date_fin;

    private String annee_academique;

    private String nationalite;

    private String matricule;

    private String sexe;

    private String departement;

    private String duree;

    public static Stagiare buildFromDto(StagiaireRequestDTO dto){
        return Stagiare.StagiareBuilder.aStagiare()
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .photo(dto.getPhoto())
                .date_naissance(dto.getDate_naissance())
                .lieu_naissance(dto.getLieu_naissance())
                .statut_matrimoniale(dto.getStatut_matrimoniale())
                .adresse(dto.getAdresse())
                .numero(dto.getNumero())
                .ecole(dto.getEcole())
                .date_debut(dto.getDate_debut())
                .date_fin(dto.getDate_fin())
                .annee_academique(dto.getAnnee_academique())
                .nationalite(dto.getNationalite())
                .matricule(dto.getMatricule())
                .sexe(dto.getSexe())
                .departement(dto.getDepartement())
                .duree(dto.getDuree())
                .build();
    }
}
