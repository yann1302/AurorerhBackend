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
    private String duree;

    @OneToMany(mappedBy = "formation")
    private List<EmployerFormation> employerFormations;

    public static final class FormationBuilder {
        private Long id;
        private String theme_form;
        private String description;
        private String duree;
        private List<EmployerFormation> employerFormations;

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

        public FormationBuilder duree(String duree) {
            this.duree = duree;
            return this;
        }

        public FormationBuilder employerFormations(List<EmployerFormation> employerFormations) {
            this.employerFormations = employerFormations;
            return this;
        }

        public Formation build() {
            Formation formation = new Formation();
            formation.setId(id);
            formation.setTheme_form(theme_form);
            formation.setDescription(description);
            formation.setDuree(duree);
            formation.setEmployerFormations(employerFormations);
            return formation;
        }
    }
}
