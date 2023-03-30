package com.advance.aurore_rh.model;

import com.advance.aurore_rh.model.lnk.EmployerFormation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "APP_FORMATION")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Formation extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String theme_form;
    private String description;
    private Long duree;
    private Date date_publication;
    private String photo;

    @OneToMany(mappedBy = "formation")
    private List<EmployerFormation> employerFormations;

    @OneToMany(mappedBy = "employer")
    private List<DemandeForm> demandeForms;

    public static final class FormationBuilder {
        private Long id;
        private String theme_form;
        private String description;
        private Long duree;
        private Date date_publication;
        private String photo;
        private List<EmployerFormation> employerFormations;
        private List<DemandeForm> demandeForms;

        private FormationBuilder() {
        }

        public static FormationBuilder aFormation() {
            return new FormationBuilder();
        }

        public FormationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public FormationBuilder theme_form(String theme_form) {
            this.theme_form = theme_form;
            return this;
        }

        public FormationBuilder description(String description) {
            this.description = description;
            return this;
        }

        public FormationBuilder duree(Long duree) {
            this.duree = duree;
            return this;
        }

        public FormationBuilder date_publication(Date date_publication) {
            this.date_publication = date_publication;
            return this;
        }

        public FormationBuilder photo(String photo) {
            this.photo = photo;
            return this;
        }

        public FormationBuilder employerFormations(List<EmployerFormation> employerFormations) {
            this.employerFormations = employerFormations;
            return this;
        }

        public FormationBuilder demandeForms(List<DemandeForm> demandeForms) {
            this.demandeForms = demandeForms;
            return this;
        }

        public Formation build() {
            Formation formation = new Formation();
            formation.setId(id);
            formation.setTheme_form(theme_form);
            formation.setDescription(description);
            formation.setDuree(duree);
            formation.setDate_publication(date_publication);
            formation.setPhoto(photo);
            formation.setEmployerFormations(employerFormations);
            formation.setDemandeForms(demandeForms);
            return formation;
        }
    }
}
