package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.lnk.EmployerFormation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder

public class SessionsFormationResponseDTO {
    private String reference;
    private String description;
    private Date debut_form;
    private Date fin_form;
    private String themeForm;
    private String formateur;
    private Long totalEmploye;
    //private FormationResponseDTO formationResponseDTO;

    public SessionsFormationResponseDTO( String reference,String description, Date debut_form, Date fin_form,String themeForm, String formateur, Long totalEmploye ) {
        this.reference = reference;
        this.description = description;
        this.debut_form = debut_form;
        this.fin_form = fin_form;
        this.themeForm = themeForm;
        this.formateur = formateur;
        this.totalEmploye = totalEmploye;
        //this.formation = formation;


    }

    public static SessionsFormationResponseDTO buildFromEntity(EmployerFormation entity){
        return SessionsFormationResponseDTO.builder()
                .description(entity.getDescription())
                .debut_form(entity.getDebut_form())
                .fin_form(entity.getFin_form())
                .formateur(entity.getFormateur())
                .themeForm(entity.getThemeForm())
                .reference(entity.getReference())
               // .formationResponseDTO(FormationResponseDTO.buildFromEntity(entity.getFormation()))
                .build();
    }

    public static List<SessionsFormationResponseDTO> buildFromEntity(List <EmployerFormation> employerFormationList){
        return employerFormationList.stream().map(SessionsFormationResponseDTO::buildFromEntity).collect(Collectors.toList());
    }
}
