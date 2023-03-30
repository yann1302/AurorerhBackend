package com.advance.aurore_rh.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PRM_ETAT_IMPRIMABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtatImprimable extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etat_imprimable")
    private Long id;

    @Column(name = "type_filtre")
    private Integer type; //  <0=Fenêtre, 1=Etat>

    @Column(nullable = false, length = 100)
    private String libelle;

//    @Column(nullable = false, length = 100)
//    private String libelle_en;

    @Column(nullable = false, length = 5000)
    private String description;

//    @Column(nullable = false, length = 5000)
//    private String description_en;

    private int numeroOrdre;

    @Column(length = 500)
    private String groupe;

    @Column(nullable = false, length = 5000)
    private String chemin;

    private int exportable; //  <0=Non, 1=Oui>

    /**
     * The Window.
     */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
//    @JoinColumn(name = "window_id", referencedColumnName = "id")
//    private WindowApp window;
}
