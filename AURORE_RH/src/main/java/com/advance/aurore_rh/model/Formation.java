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



//    @ManyToMany(mappedBy = "formations")
//    private List<Employer> employers;

    @OneToMany(mappedBy = "formation")
    private List<EmployerFormation> employerFormations;

    public static final class FormationBuilder {
        private Long id;
        private String theme_form;
        private List<EmployerFormation> employerFormations;
        private Long version;
        private LocalDateTime date_creation;
        private LocalDateTime date_modif;
        private String util_creation;
        private String util_modif;
        private Character forwarded;

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

        public FormationBuilder employerFormations(List<EmployerFormation> employerFormations) {
            this.employerFormations = employerFormations;
            return this;
        }

        public FormationBuilder version(Long version) {
            this.version = version;
            return this;
        }

        public FormationBuilder date_creation(LocalDateTime date_creation) {
            this.date_creation = date_creation;
            return this;
        }

        public FormationBuilder date_modif(LocalDateTime date_modif) {
            this.date_modif = date_modif;
            return this;
        }

        public FormationBuilder util_creation(String util_creation) {
            this.util_creation = util_creation;
            return this;
        }

        public FormationBuilder util_modif(String util_modif) {
            this.util_modif = util_modif;
            return this;
        }

        public FormationBuilder forwarded(Character forwarded) {
            this.forwarded = forwarded;
            return this;
        }

        public Formation build() {
            Formation formation = new Formation();
            formation.setId(id);
            formation.setTheme_form(theme_form);
            formation.setEmployerFormations(employerFormations);
            formation.setVersion(version);
            formation.setDate_creation(date_creation);
            formation.setDate_modif(date_modif);
            formation.setUtil_creation(util_creation);
            formation.setUtil_modif(util_modif);
            formation.setForwarded(forwarded);
            return formation;
        }
    }
}
