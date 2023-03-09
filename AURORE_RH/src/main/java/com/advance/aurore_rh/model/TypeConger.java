package com.advance.aurore_rh.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "APP_TYPECONGER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeConger extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String type_conger;

    @Column(length = 50)
    private String description;

    @OneToMany(mappedBy = "typeConger")
    private List<Conger> conger;

    public static final class TypeCongerBuilder {
        private Long id;
        private String type_conger;
        private String description;
        private List<Conger> conger;
        private Long version;
        private LocalDateTime date_creation;
        private LocalDateTime date_modif;
        private String util_creation;
        private String util_modif;
        private Character forwarded;

        private TypeCongerBuilder() {
        }

        public static TypeCongerBuilder aTypeConger() {
            return new TypeCongerBuilder();
        }

        public TypeCongerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TypeCongerBuilder type_conger(String type_conger) {
            this.type_conger = type_conger;
            return this;
        }

        public TypeCongerBuilder description(String description) {
            this.description = description;
            return this;
        }

        public TypeCongerBuilder conger(List<Conger> conger) {
            this.conger = conger;
            return this;
        }

        public TypeCongerBuilder version(Long version) {
            this.version = version;
            return this;
        }

        public TypeCongerBuilder date_creation(LocalDateTime date_creation) {
            this.date_creation = date_creation;
            return this;
        }

        public TypeCongerBuilder date_modif(LocalDateTime date_modif) {
            this.date_modif = date_modif;
            return this;
        }

        public TypeCongerBuilder util_creation(String util_creation) {
            this.util_creation = util_creation;
            return this;
        }

        public TypeCongerBuilder util_modif(String util_modif) {
            this.util_modif = util_modif;
            return this;
        }

        public TypeCongerBuilder forwarded(Character forwarded) {
            this.forwarded = forwarded;
            return this;
        }

        public TypeConger build() {
            TypeConger typeConger = new TypeConger();
            typeConger.setId(id);
            typeConger.setType_conger(type_conger);
            typeConger.setDescription(description);
            typeConger.setConger(conger);
            typeConger.setVersion(version);
            typeConger.setDate_creation(date_creation);
            typeConger.setDate_modif(date_modif);
            typeConger.setUtil_creation(util_creation);
            typeConger.setUtil_modif(util_modif);
            typeConger.setForwarded(forwarded);
            return typeConger;
        }
    }
}
