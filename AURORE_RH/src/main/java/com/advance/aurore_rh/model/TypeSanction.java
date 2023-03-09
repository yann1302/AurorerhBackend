package com.advance.aurore_rh.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "APP_TYPESANCTION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeSanction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String type_sanction;


    @OneToMany(mappedBy = "typeSanction")
    private List<Sanction> sanction;

    public static final class TypeSanctionBuilder {
        private Long id;
        private String type_sanction;
        private List<Sanction> sanction;

        private TypeSanctionBuilder() {
        }

        public static TypeSanctionBuilder aTypeSanction() {
            return new TypeSanctionBuilder();
        }

        public TypeSanctionBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public TypeSanctionBuilder type_sanction(String type_sanction) {
            this.type_sanction = type_sanction;
            return this;
        }

        public TypeSanctionBuilder sanction(List<Sanction> sanction) {
            this.sanction = sanction;
            return this;
        }

        public TypeSanction build() {
            TypeSanction typeSanction = new TypeSanction();
            typeSanction.setId(id);
            typeSanction.setType_sanction(type_sanction);
            typeSanction.setSanction(sanction);
            return typeSanction;
        }
    }
}
