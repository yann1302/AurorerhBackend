package com.advance.aurore_rh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APP_STAGIAIRE")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Stagiaire extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String codeStage;
    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String prenom;
    private String photo;
    private Date date_naissance;
    @Column(length = 50)
    private String lieu_naissance;
    @Column(length = 50)
    private String statut_matrimoniale;
    @Column(length = 50)
    private String adresse;
    @Column(length = 50)
    private long numero;
    @Column(length = 50)
    private String ecole;
    private Date date_debut;
    private  Date date_fin;
    @Column(length = 50)
    private String annee_academique;
    @Column(length = 50)
    private String nationalite;
    @Column(length = 50)
    private String matricule;
    @Column(length = 50)
    private String sexe;
    @Column(length = 50)
    private String departement;
    @Column(length = 50)
    private String duree;

    public static final class StagiaireBuilder {
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
        private Date date_fin;
        private String annee_academique;
        private String nationalite;
        private String matricule;
        private String sexe;
        private String departement;
        private String duree;

        private StagiaireBuilder() {
        }

        public static StagiaireBuilder aStagiaire() {
            return new StagiaireBuilder();
        }

        public StagiaireBuilder id(long id) {
            this.id = id;
            return this;
        }

        public StagiaireBuilder codeStage(String codeStage) {
            this.codeStage = codeStage;
            return this;
        }

        public StagiaireBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public StagiaireBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public StagiaireBuilder photo(String photo) {
            this.photo = photo;
            return this;
        }

        public StagiaireBuilder date_naissance(Date date_naissance) {
            this.date_naissance = date_naissance;
            return this;
        }

        public StagiaireBuilder lieu_naissance(String lieu_naissance) {
            this.lieu_naissance = lieu_naissance;
            return this;
        }

        public StagiaireBuilder statut_matrimoniale(String statut_matrimoniale) {
            this.statut_matrimoniale = statut_matrimoniale;
            return this;
        }

        public StagiaireBuilder adresse(String adresse) {
            this.adresse = adresse;
            return this;
        }

        public StagiaireBuilder numero(long numero) {
            this.numero = numero;
            return this;
        }

        public StagiaireBuilder ecole(String ecole) {
            this.ecole = ecole;
            return this;
        }

        public StagiaireBuilder date_debut(Date date_debut) {
            this.date_debut = date_debut;
            return this;
        }

        public StagiaireBuilder date_fin(Date date_fin) {
            this.date_fin = date_fin;
            return this;
        }

        public StagiaireBuilder annee_academique(String annee_academique) {
            this.annee_academique = annee_academique;
            return this;
        }

        public StagiaireBuilder nationalite(String nationalite) {
            this.nationalite = nationalite;
            return this;
        }

        public StagiaireBuilder matricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public StagiaireBuilder sexe(String sexe) {
            this.sexe = sexe;
            return this;
        }

        public StagiaireBuilder departement(String departement) {
            this.departement = departement;
            return this;
        }

        public StagiaireBuilder duree(String duree) {
            this.duree = duree;
            return this;
        }

        public Stagiaire build() {
            Stagiaire stagiaire = new Stagiaire();
            stagiaire.setId(id);
            stagiaire.setCodeStage(codeStage);
            stagiaire.setNom(nom);
            stagiaire.setPrenom(prenom);
            stagiaire.setPhoto(photo);
            stagiaire.setDate_naissance(date_naissance);
            stagiaire.setLieu_naissance(lieu_naissance);
            stagiaire.setStatut_matrimoniale(statut_matrimoniale);
            stagiaire.setAdresse(adresse);
            stagiaire.setNumero(numero);
            stagiaire.setEcole(ecole);
            stagiaire.setDate_debut(date_debut);
            stagiaire.setDate_fin(date_fin);
            stagiaire.setAnnee_academique(annee_academique);
            stagiaire.setNationalite(nationalite);
            stagiaire.setMatricule(matricule);
            stagiaire.setSexe(sexe);
            stagiaire.setDepartement(departement);
            stagiaire.setDuree(duree);
            return stagiaire;
        }
    }
}
