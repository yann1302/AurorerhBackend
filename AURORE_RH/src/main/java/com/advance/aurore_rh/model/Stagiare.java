package com.advance.aurore_rh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "APP_STAGIAIRE")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Stagiare extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    public static final class StagiareBuilder {
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
        private Date date_fin;
        private String annee_academique;
        private String nationalite;
        private String matricule;
        private String sexe;
        private String departement;
        private String duree;

        private StagiareBuilder() {
        }

        public static StagiareBuilder aStagiare() {
            return new StagiareBuilder();
        }

        public StagiareBuilder id(long id) {
            this.id = id;
            return this;
        }

        public StagiareBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public StagiareBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public StagiareBuilder photo(String photo) {
            this.photo = photo;
            return this;
        }

        public StagiareBuilder date_naissance(Date date_naissance) {
            this.date_naissance = date_naissance;
            return this;
        }

        public StagiareBuilder lieu_naissance(String lieu_naissance) {
            this.lieu_naissance = lieu_naissance;
            return this;
        }

        public StagiareBuilder statut_matrimoniale(String statut_matrimoniale) {
            this.statut_matrimoniale = statut_matrimoniale;
            return this;
        }

        public StagiareBuilder adresse(String adresse) {
            this.adresse = adresse;
            return this;
        }

        public StagiareBuilder numero(long numero) {
            this.numero = numero;
            return this;
        }

        public StagiareBuilder ecole(String ecole) {
            this.ecole = ecole;
            return this;
        }

        public StagiareBuilder date_debut(Date date_debut) {
            this.date_debut = date_debut;
            return this;
        }

        public StagiareBuilder date_fin(Date date_fin) {
            this.date_fin = date_fin;
            return this;
        }

        public StagiareBuilder annee_academique(String annee_academique) {
            this.annee_academique = annee_academique;
            return this;
        }

        public StagiareBuilder nationalite(String nationalite) {
            this.nationalite = nationalite;
            return this;
        }

        public StagiareBuilder matricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public StagiareBuilder sexe(String sexe) {
            this.sexe = sexe;
            return this;
        }

        public StagiareBuilder departement(String departement) {
            this.departement = departement;
            return this;
        }

        public StagiareBuilder duree(String duree) {
            this.duree = duree;
            return this;
        }

        public Stagiare build() {
            Stagiare stagiare = new Stagiare();
            stagiare.setId(id);
            stagiare.setNom(nom);
            stagiare.setPrenom(prenom);
            stagiare.setPhoto(photo);
            stagiare.setDate_naissance(date_naissance);
            stagiare.setLieu_naissance(lieu_naissance);
            stagiare.setStatut_matrimoniale(statut_matrimoniale);
            stagiare.setAdresse(adresse);
            stagiare.setNumero(numero);
            stagiare.setEcole(ecole);
            stagiare.setDate_debut(date_debut);
            stagiare.setDate_fin(date_fin);
            stagiare.setAnnee_academique(annee_academique);
            stagiare.setNationalite(nationalite);
            stagiare.setMatricule(matricule);
            stagiare.setSexe(sexe);
            stagiare.setDepartement(departement);
            stagiare.setDuree(duree);
            return stagiare;
        }
    }
}
