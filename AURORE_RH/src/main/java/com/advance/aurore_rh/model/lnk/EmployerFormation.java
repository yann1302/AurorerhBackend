package com.advance.aurore_rh.model.lnk;


import com.advance.aurore_rh.model.AuditEntity;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "LNK_EMPLOYER_FORMATION")
@NoArgsConstructor
@AllArgsConstructor
public class EmployerFormation extends AuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date debut_form;

    private Date fin_form;

    @Column(length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

}
