package com.advance.aurore_rh.dto.request;

import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.User;
import com.advance.aurore_rh.utils.GeneralUtils;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@Builder

public class UserEmployerRequestDTO {

    private Long id;
    private String codeEmployer;
    private String nom;
    private String prenom;
    private String photo;
    private Date date_naissance;
    private String lieu_naissance;
    private String statut_matrimoniale;
    private String adresse;
    private long numero;
    private String type_contrat;
    private Date date_debut;
    private  Date date_fin;
    private String ville_exertion;
    private String nationalite;
    private String matricule;
    private String sexe;
    private long nbr_enfant;
    private String profession;
    private String poste;
    private String username;
    private String password;

    public  static Employer buildFromDtoEmployer(UserEmployerRequestDTO dto){
        return Employer.EmployerBuilder.anEmployer()
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .adresse(dto.getAdresse())
                .date_naissance(dto.getDate_naissance())
                .lieu_naissance(dto.getLieu_naissance())
                .matricule(dto.getMatricule())
                .photo(dto.getPhoto())
                .nationalite(dto.getNationalite())
                .nbr_enfant(dto.getNbr_enfant())
                .poste(dto.getPoste())
                .sexe(dto.getSexe())
                .numero(dto.getNumero())
                .ville_exertion(dto.getVille_exertion())
                .type_contrat(dto.getType_contrat())
                .date_debut(dto.getDate_debut())
                .date_fin(dto.getDate_fin())
                .statut_matrimoniale(dto.getStatut_matrimoniale())
                .profession(dto.getProfession())
               .codeEmployer(dto.getCodeEmployer())
                .build();
    }

    public static User buildFromDtoUser(UserEmployerRequestDTO dto, Employer employer){
        return User.UserBuilder.anUser()
                .username(dto.getUsername())
                .password(GeneralUtils.genererPasswordUser(dto.getPassword()))
                .employer(employer)
                .build();
    }
}
