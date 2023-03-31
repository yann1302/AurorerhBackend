package com.advance.aurore_rh.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "log_activite")
public class Activite extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activite")
    private Long id;

    @Column(name = "date_evt", nullable = false)
    private LocalDateTime dateEvenement = LocalDateTime.now();

    @Column(name = "details_evt", nullable = false, length = 5000)
    private String details;

    @Column(name = "nom_utilisateur", nullable = false, length = 500)
    private String nomUtilisateur = "SYSTEM";

    @Column(name = "libelle_role", nullable = false, length = 5000)
    private String libelleRole = "SYSTEM";

    @Lob
    @Column(name = "parametres")
    private String parametres;

    @Column(name = "source_evt", length = 5000)
    private String source;

    @Column(name = "exception_erreur", length = 1000)
    private String erreur;

}