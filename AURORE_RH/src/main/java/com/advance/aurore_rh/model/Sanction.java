package com.advance.aurore_rh.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "APP_SANCTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sanction extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sanction;


    @Column(length = 50)
    private String type_sanction;

    private String description;

    private Date debut_sanction;

    private Date fin_sanction;

    @Column(length = 50)
    private String statut;

    @ManyToOne
    @JoinColumn(name = "typesaction_id")
    private TypeSanction typeSanction;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name = "employer_id")
    @ManyToOne(targetEntity = Employer.class)
    private Employer employer;


    public static final class SanctionBuilder {
        private Long id_sanction;
        private String type_sanction;
        private String description;
        private Date debut_sanction;
        private Date fin_sanction;
        private String statut;
        private TypeSanction typeSanction;
        private Employer employer;

        private SanctionBuilder() {
        }

        public static SanctionBuilder aSanction() {
            return new SanctionBuilder();
        }

        public SanctionBuilder id_sanction(Long id_sanction) {
            this.id_sanction = id_sanction;
            return this;
        }

        public SanctionBuilder type_sanction(String type_sanction) {
            this.type_sanction = type_sanction;
            return this;
        }

        public SanctionBuilder description(String description) {
            this.description = description;
            return this;
        }

        public SanctionBuilder debut_sanction(Date debut_sanction) {
            this.debut_sanction = debut_sanction;
            return this;
        }

        public SanctionBuilder fin_sanction(Date fin_sanction) {
            this.fin_sanction = fin_sanction;
            return this;
        }

        public SanctionBuilder statut(String statut) {
            this.statut = statut;
            return this;
        }

        public SanctionBuilder typeSanction(TypeSanction typeSanction) {
            this.typeSanction = typeSanction;
            return this;
        }

        public SanctionBuilder employer(Employer employer) {
            this.employer = employer;
            return this;
        }

        public Sanction build() {
            Sanction sanction = new Sanction();
            sanction.setId_sanction(id_sanction);
            sanction.setType_sanction(type_sanction);
            sanction.setDescription(description);
            sanction.setDebut_sanction(debut_sanction);
            sanction.setFin_sanction(fin_sanction);
            sanction.setStatut(statut);
            sanction.setTypeSanction(typeSanction);
            sanction.setEmployer(employer);
            return sanction;
        }
    }
}
