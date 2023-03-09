package com.advance.aurore_rh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "APP_TYPECONTRAT")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TypeContrat extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String typecontrat;

    @Column(length = 50)
    private String description;

    @OneToMany(mappedBy = "typeContrat")
    private List<Contrat> contrat;

    public static final class TypeContratBuilder {
        private Long id;
        private String type_contrat;
        private String description;
        private List<Contrat> contrat;
        private Long version;
        private LocalDateTime date_creation;
        private LocalDateTime date_modif;
        private String util_creation;
        private String util_modif;
        private Character forwarded;

        private TypeContratBuilder() {
        }

        public static TypeContratBuilder aTypeContrat() {
            return new TypeContratBuilder();
        }

        public TypeContratBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TypeContratBuilder type_contrat(String type_contrat) {
            this.type_contrat = type_contrat;
            return this;
        }

        public TypeContratBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TypeContratBuilder contrat(List<Contrat> contrat) {
            this.contrat = contrat;
            return this;
        }

        public TypeContratBuilder version(Long version) {
            this.version = version;
            return this;
        }

        public TypeContratBuilder date_creation(LocalDateTime date_creation) {
            this.date_creation = date_creation;
            return this;
        }

        public TypeContratBuilder date_modif(LocalDateTime date_modif) {
            this.date_modif = date_modif;
            return this;
        }

        public TypeContratBuilder util_creation(String util_creation) {
            this.util_creation = util_creation;
            return this;
        }

        public TypeContratBuilder util_modif(String util_modif) {
            this.util_modif = util_modif;
            return this;
        }

        public TypeContratBuilder forwarded(Character forwarded) {
            this.forwarded = forwarded;
            return this;
        }

        public TypeContrat build() {
            TypeContrat typeContrat = new TypeContrat();
            typeContrat.setId(id);
            typeContrat.setTypecontrat(type_contrat);
            typeContrat.setDescription(description);
            typeContrat.setContrat(contrat);
            typeContrat.setVersion(version);
            typeContrat.setDate_creation(date_creation);
            typeContrat.setDate_modif(date_modif);
            typeContrat.setUtil_creation(util_creation);
            typeContrat.setUtil_modif(util_modif);
            typeContrat.setForwarded(forwarded);
            return typeContrat;
        }
    }
}
