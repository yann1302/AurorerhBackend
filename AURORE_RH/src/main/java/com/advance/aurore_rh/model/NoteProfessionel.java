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
@Table(name = "APP_NOTEPROFESSIONEL")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NoteProfessionel extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String theme;

    @Column(length = 100)
    private String description;

    private Date date_publication;

    @ManyToMany(mappedBy = "noteProfessionels")
    private List<Employer> employers;

    public static final class NoteProfessionelBuilder {
        private Long id;
        private String theme;
        private String description;
        private Date date_publication;
        private List<Employer> employers;
        private Long version;
        private LocalDateTime date_creation;
        private LocalDateTime date_modif;
        private String util_creation;
        private String util_modif;
        private Character forwarded;

        private NoteProfessionelBuilder() {
        }

        public static NoteProfessionelBuilder aNoteProfessionel() {
            return new NoteProfessionelBuilder();
        }

        public NoteProfessionelBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public NoteProfessionelBuilder theme(String theme) {
            this.theme = theme;
            return this;
        }

        public NoteProfessionelBuilder description(String description) {
            this.description = description;
            return this;
        }

        public NoteProfessionelBuilder date_publication(Date date_publication) {
            this.date_publication = date_publication;
            return this;
        }

        public NoteProfessionelBuilder employers(List<Employer> employers) {
            this.employers = employers;
            return this;
        }

        public NoteProfessionelBuilder version(Long version) {
            this.version = version;
            return this;
        }

        public NoteProfessionelBuilder date_creation(LocalDateTime date_creation) {
            this.date_creation = date_creation;
            return this;
        }

        public NoteProfessionelBuilder date_modif(LocalDateTime date_modif) {
            this.date_modif = date_modif;
            return this;
        }

        public NoteProfessionelBuilder util_creation(String util_creation) {
            this.util_creation = util_creation;
            return this;
        }

        public NoteProfessionelBuilder util_modif(String util_modif) {
            this.util_modif = util_modif;
            return this;
        }

        public NoteProfessionelBuilder forwarded(Character forwarded) {
            this.forwarded = forwarded;
            return this;
        }

        public NoteProfessionel build() {
            NoteProfessionel noteProfessionel = new NoteProfessionel();
            noteProfessionel.setId(id);
            noteProfessionel.setTheme(theme);
            noteProfessionel.setDescription(description);
            noteProfessionel.setDate_publication(date_publication);
            noteProfessionel.setEmployers(employers);
            noteProfessionel.setVersion(version);
            noteProfessionel.setDate_creation(date_creation);
            noteProfessionel.setDate_modif(date_modif);
            noteProfessionel.setUtil_creation(util_creation);
            noteProfessionel.setUtil_modif(util_modif);
            noteProfessionel.setForwarded(forwarded);
            return noteProfessionel;
        }
    }
}
