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

    private String photo;

    private String description;

    private Date date_publication;


    public static final class NoteProfessionelBuilder {
        private Long id;
        private String theme;
        private String photo;
        private String description;
        private Date date_publication;

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

        public NoteProfessionelBuilder photo(String photo) {
            this.photo = photo;
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

        public NoteProfessionel build() {
            NoteProfessionel noteProfessionel = new NoteProfessionel();
            noteProfessionel.setId(id);
            noteProfessionel.setTheme(theme);
            noteProfessionel.setPhoto(photo);
            noteProfessionel.setDescription(description);
            noteProfessionel.setDate_publication(date_publication);
            return noteProfessionel;
        }
    }

    // @ManyToMany(mappedBy = "noteProfessionels")
    //private List<Employer> employers;

}
