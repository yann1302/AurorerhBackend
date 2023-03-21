package com.advance.aurore_rh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "APP_DEMANDE_FORMATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemandeForm extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private Date date_demande;
    private String statut;


    @ManyToOne
    private Employer employer;

    @ManyToOne
    private Formation formation;

    public static final class DemandeFormBuilder {
        private long id;
        private Date date_demande;
        private String statut;
        private Employer employer;
        private Formation formation;

        private DemandeFormBuilder() {
        }

        public static DemandeFormBuilder aDemandeForm() {
            return new DemandeFormBuilder();
        }

        public DemandeFormBuilder id(long id) {
            this.id = id;
            return this;
        }

        public DemandeFormBuilder date_demande(Date date_demande) {
            this.date_demande = date_demande;
            return this;
        }

        public DemandeFormBuilder statut(String statut) {
            this.statut = statut;
            return this;
        }

        public DemandeFormBuilder employer(Employer employer) {
            this.employer = employer;
            return this;
        }

        public DemandeFormBuilder formation(Formation formation) {
            this.formation = formation;
            return this;
        }

        public DemandeForm build() {
            DemandeForm demandeForm = new DemandeForm();
            demandeForm.setId(id);
            demandeForm.setDate_demande(date_demande);
            demandeForm.setStatut(statut);
            demandeForm.setEmployer(employer);
            demandeForm.setFormation(formation);
            return demandeForm;
        }
    }
}
