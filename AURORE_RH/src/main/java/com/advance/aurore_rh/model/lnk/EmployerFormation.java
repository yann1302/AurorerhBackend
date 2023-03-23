package com.advance.aurore_rh.model.lnk;


import com.advance.aurore_rh.model.AuditEntity;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "LNK_EMPLOYER_FORMATION")
@NoArgsConstructor
@AllArgsConstructor
public class EmployerFormation extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reference;
    private String themeForm;
    private Date debut_form;
    private Date fin_form;
    private String formateur;
    private String description;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    public static final class EmployerFormationBuilder {
        private Long id;
        private String reference;
        private String themeForm;
        private Date debut_form;
        private Date fin_form;
        private String formateur;
        private String description;
        private Employer employer;
        private Formation formation;

        private EmployerFormationBuilder() {
        }

        public static EmployerFormationBuilder anEmployerFormation() {
            return new EmployerFormationBuilder();
        }

        public EmployerFormationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public EmployerFormationBuilder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public EmployerFormationBuilder themeForm(String themeForm) {
            this.themeForm = themeForm;
            return this;
        }

        public EmployerFormationBuilder debut_form(Date debut_form) {
            this.debut_form = debut_form;
            return this;
        }

        public EmployerFormationBuilder fin_form(Date fin_form) {
            this.fin_form = fin_form;
            return this;
        }

        public EmployerFormationBuilder formateur(String formateur) {
            this.formateur = formateur;
            return this;
        }

        public EmployerFormationBuilder description(String description) {
            this.description = description;
            return this;
        }

        public EmployerFormationBuilder employer(Employer employer) {
            this.employer = employer;
            return this;
        }

        public EmployerFormationBuilder formation(Formation formation) {
            this.formation = formation;
            return this;
        }

        public EmployerFormation build() {
            EmployerFormation employerFormation = new EmployerFormation();
            employerFormation.setId(id);
            employerFormation.setReference(reference);
            employerFormation.setThemeForm(themeForm);
            employerFormation.setDebut_form(debut_form);
            employerFormation.setFin_form(fin_form);
            employerFormation.setFormateur(formateur);
            employerFormation.setDescription(description);
            employerFormation.setEmployer(employer);
            employerFormation.setFormation(formation);
            return employerFormation;
        }
    }
}
