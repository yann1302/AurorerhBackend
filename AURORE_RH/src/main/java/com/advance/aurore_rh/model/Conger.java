package com.advance.aurore_rh.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "APP_CONGER")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Conger extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(length = 50)
    private String nom;

    @Column(length = 50)
    private String prenom;

    private Date date_debut;

    private Date date_fin;

    @Column(length = 50)
    private String type_conger;

    private Date date_reprise;

    private String validation;

    private Date etablissement_conger;

    private String description;

    @ManyToOne
    @JoinColumn(name = "typeconger_id")
    private TypeConger typeConger;

    @ManyToOne
    private Employer employer;


    public static final class CongerBuilder {
        private Long id;
        private String nom;
        private String prenom;
        private Date date_debut;
        private Date date_fin;
        private String type_conger;
        private Date date_reprise;
        private String validation;
        private Date etablissement_conger;
        private String description;
        private TypeConger typeConger;
        private Employer employer;

        private CongerBuilder() {
        }

        public static CongerBuilder aConger() {
            return new CongerBuilder();
        }

        public CongerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CongerBuilder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public CongerBuilder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public CongerBuilder date_debut(Date date_debut) {
            this.date_debut = date_debut;
            return this;
        }

        public CongerBuilder date_fin(Date date_fin) {
            this.date_fin = date_fin;
            return this;
        }

        public CongerBuilder type_conger(String type_conger) {
            this.type_conger = type_conger;
            return this;
        }

        public CongerBuilder date_reprise(Date date_reprise) {
            this.date_reprise = date_reprise;
            return this;
        }

        public CongerBuilder validation(String validation) {
            this.validation = validation;
            return this;
        }

        public CongerBuilder etablissement_conger(Date etablissement_conger) {
            this.etablissement_conger = etablissement_conger;
            return this;
        }

        public CongerBuilder description(String description) {
            this.description = description;
            return this;
        }

        public CongerBuilder typeConger(TypeConger typeConger) {
            this.typeConger = typeConger;
            return this;
        }

        public CongerBuilder employer(Employer employer) {
            this.employer = employer;
            return this;
        }

        public Conger build() {
            Conger conger = new Conger();
            conger.setId(id);
            conger.setNom(nom);
            conger.setPrenom(prenom);
            conger.setDate_debut(date_debut);
            conger.setDate_fin(date_fin);
            conger.setType_conger(type_conger);
            conger.setDate_reprise(date_reprise);
            conger.setValidation(validation);
            conger.setEtablissement_conger(etablissement_conger);
            conger.setDescription(description);
            conger.setTypeConger(typeConger);
            conger.setEmployer(employer);
            return conger;
        }
    }
}
