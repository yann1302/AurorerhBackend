package com.advance.aurore_rh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRM_NUMEROTATION")
public class Numerotation extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_numerotation")
    private Long id;
    @Column(name = "souche", length = 500)
    private String souche;
    @Column(name = "num_index")
    private long numeroIndex;
    @Column(name = "code", length = 50)
    private String code;
    @Column(name = "description", length = 500)
    private String description;

    public static final class NumerotationBuilder {
        private Long id;
        private String souche;
        private long numeroIndex;
        private String code;
        private String description;

        private NumerotationBuilder() {
        }

        public static NumerotationBuilder aNumerotation() {
            return new NumerotationBuilder();
        }

        public NumerotationBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public NumerotationBuilder souche(String souche) {
            this.souche = souche;
            return this;
        }

        public NumerotationBuilder numeroIndex(long numeroIndex) {
            this.numeroIndex = numeroIndex;
            return this;
        }

        public NumerotationBuilder code(String code) {
            this.code = code;
            return this;
        }

        public NumerotationBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Numerotation build() {
            Numerotation numerotation = new Numerotation();
            numerotation.setId(id);
            numerotation.setSouche(souche);
            numerotation.setNumeroIndex(numeroIndex);
            numerotation.setCode(code);
            numerotation.setDescription(description);
            return numerotation;
        }
    }
}
