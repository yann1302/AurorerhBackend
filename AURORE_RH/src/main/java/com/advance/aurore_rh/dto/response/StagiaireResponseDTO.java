package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.Stagiaire;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class StagiaireResponseDTO {

    private long id;
    private String codeStage;
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

    public static StagiaireResponseDTO buildFromEntity(Stagiaire entity){
        return StagiaireResponseDTO.builder()
                .id(entity.getId())
                .codeStage(entity.getCodeStage())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .photo(entity.getPhoto())
                .date_naissance(entity.getDate_naissance())
                .lieu_naissance(entity.getLieu_naissance())
                .annee_academique(entity.getAnnee_academique())
                .date_debut(entity.getDate_debut())
                .date_fin(entity.getDate_fin())
                .adresse(entity.getAdresse())
                .departement(entity.getDepartement())
                .matricule(entity.getMatricule())
                .ecole(entity.getEcole())
                .duree(entity.getDuree())
                .nationalite(entity.getNationalite())
                .numero(entity.getNumero())
                .sexe(entity.getSexe())

                .build();
    }

    public static List<StagiaireResponseDTO> builFromEntityList(List <Stagiaire> stagiaireList){
        return stagiaireList.stream().map(StagiaireResponseDTO::buildFromEntity).collect(Collectors.toList());
    }

    public static Page<StagiaireResponseDTO> buildFromEntityPage(Page<Stagiaire> entityList) {
        return entityList.map(StagiaireResponseDTO::buildFromEntity);
    }
}
