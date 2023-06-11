package com.advance.aurore_rh.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "APP_CONTRAT")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contrat extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_contrat;
    @Column(length = 50)
    private String nom;
    @Column(length = 50)
    private String prenom;
    @Column(length = 50)
    private String lieu_recrutememnt;
    private String date_embauche;
    private Long periode_essaie;
    private String debut_periode_essaie;
    private String fin_periode_essaie;
    private String debut_essaie;
    private String fin_essaie;
    @Column(length = 50)
    private String type_contrat;
    @Column(length = 50)
    private String poste;
    @Column(length = 50)
    private String statut;
    @Column(length = 50)
    private String lieu_travail;
    @Column(length = 50)
    private String Salaire_brut;
    @Column(length = 50)
    private String etat_civil;
    @Column(length = 50)
    private String liste_diplo;
    private String document;
    private Long congerAnnuel;
    private Long duree_cdd;
    private int Jours_de_conges_pris;
    @ManyToOne
    @JoinColumn(name  = "employer_id")
    public Employer employer;


    @ManyToOne
    @JoinColumn(name  = "typecontrat_id")
    private TypeContrat typeContrat;

    @ManyToOne
    public Conger conger;

    public static final class ContratBuilder {
        private long id_contrat;
        private String nom;
        private String prenom;
        private String lieu_recrutememnt;
        private String date_embauche;
        private Long periode_essaie;
        private String debut_periode_essaie;
        private String fin_periode_essaie;
        private String debut_essaie;
        private String fin_essaie;
        private String type_contrat;
        private String poste;
        private String statut;
        private String lieu_travail;
        private String Salaire_brut;
        private String etat_civil;
        private String liste_diplo;
        private String document;
        private Long congerAnnuel;
        private Long duree_cdd;
        private int Jours_de_conges_pris;
        private Employer employer;
        private TypeContrat typeContrat;
        private Conger conger;

        private ContratBuilder() {
        }

        public static ContratBuilder aContrat() {
            return new ContratBuilder();
        }

        public ContratBuilder id_contrat(long id_contrat) {
            this.id_contrat = id_contrat;
            return this;
        }

        public ContratBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public ContratBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public ContratBuilder lieu_recrutememnt(String lieu_recrutememnt) {
            this.lieu_recrutememnt = lieu_recrutememnt;
            return this;
        }

        public ContratBuilder date_embauche(String date_embauche) {
            this.date_embauche = date_embauche;
            return this;
        }

        public ContratBuilder periode_essaie(Long periode_essaie) {
            this.periode_essaie = periode_essaie;
            return this;
        }

        public ContratBuilder debut_periode_essaie(String debut_periode_essaie) {
            this.debut_periode_essaie = debut_periode_essaie;
            return this;
        }

        public ContratBuilder fin_periode_essaie(String fin_periode_essaie) {
            this.fin_periode_essaie = fin_periode_essaie;
            return this;
        }

        public ContratBuilder debut_essaie(String debut_essaie) {
            this.debut_essaie = debut_essaie;
            return this;
        }

        public ContratBuilder fin_essaie(String fin_essaie) {
            this.fin_essaie = fin_essaie;
            return this;
        }

        public ContratBuilder type_contrat(String type_contrat) {
            this.type_contrat = type_contrat;
            return this;
        }

        public ContratBuilder poste(String poste) {
            this.poste = poste;
            return this;
        }

        public ContratBuilder statut(String statut) {
            this.statut = statut;
            return this;
        }

        public ContratBuilder lieu_travail(String lieu_travail) {
            this.lieu_travail = lieu_travail;
            return this;
        }

        public ContratBuilder Salaire_brut(String Salaire_brut) {
            this.Salaire_brut = Salaire_brut;
            return this;
        }

        public ContratBuilder etat_civil(String etat_civil) {
            this.etat_civil = etat_civil;
            return this;
        }

        public ContratBuilder liste_diplo(String liste_diplo) {
            this.liste_diplo = liste_diplo;
            return this;
        }

        public ContratBuilder document(String document) {
            this.document = document;
            return this;
        }

        public ContratBuilder congerAnnuel(Long congerAnnuel) {
            this.congerAnnuel = congerAnnuel;
            return this;
        }

        public ContratBuilder duree_cdd(Long duree_cdd) {
            this.duree_cdd = duree_cdd;
            return this;
        }

        public ContratBuilder Jours_de_conges_pris(int Jours_de_conges_pris) {
            this.Jours_de_conges_pris = Jours_de_conges_pris;
            return this;
        }

        public ContratBuilder employer(Employer employer) {
            this.employer = employer;
            return this;
        }

        public ContratBuilder typeContrat(TypeContrat typeContrat) {
            this.typeContrat = typeContrat;
            return this;
        }

        public ContratBuilder conger(Conger conger) {
            this.conger = conger;
            return this;
        }

        public Contrat build() {
            Contrat contrat = new Contrat();
            contrat.setId_contrat(id_contrat);
            contrat.setNom(nom);
            contrat.setPrenom(prenom);
            contrat.setLieu_recrutememnt(lieu_recrutememnt);
            contrat.setDate_embauche(date_embauche);
            contrat.setPeriode_essaie(periode_essaie);
            contrat.setDebut_periode_essaie(debut_periode_essaie);
            contrat.setFin_periode_essaie(fin_periode_essaie);
            contrat.setDebut_essaie(debut_essaie);
            contrat.setFin_essaie(fin_essaie);
            contrat.setType_contrat(type_contrat);
            contrat.setPoste(poste);
            contrat.setStatut(statut);
            contrat.setLieu_travail(lieu_travail);
            contrat.setSalaire_brut(Salaire_brut);
            contrat.setEtat_civil(etat_civil);
            contrat.setListe_diplo(liste_diplo);
            contrat.setDocument(document);
            contrat.setCongerAnnuel(congerAnnuel);
            contrat.setDuree_cdd(duree_cdd);
            contrat.setJours_de_conges_pris(Jours_de_conges_pris);
            contrat.setEmployer(employer);
            contrat.setTypeContrat(typeContrat);
            contrat.setConger(conger);
            return contrat;
        }
    }
}
