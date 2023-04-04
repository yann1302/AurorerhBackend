package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.dto.request.UserEmployerRequestDTO;
import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Sanction;
import com.advance.aurore_rh.model.User;
import com.advance.aurore_rh.utils.GeneralUtils;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class EmployerResponseDTO {

    private long id;
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
    private String statut;
    private int nbConges;
    private List<SanctionResponseDTO> sanctions;
    private List<CongerResponseDTO> congers;

    public  static EmployerResponseDTO buildFromEntity(Employer entity){
        return EmployerResponseDTO.builder()
                .id(entity.getId())
                .codeEmployer(entity.getCodeEmployer())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .adresse(entity.getAdresse())
                .date_naissance(entity.getDate_naissance())
                .lieu_naissance(entity.getLieu_naissance())
                .matricule(entity.getMatricule())
                .photo(entity.getPhoto())
                .nationalite(entity.getNationalite())
                .nbr_enfant(entity.getNbr_enfant())
                .poste(entity.getPoste())
                .sexe(entity.getSexe())
                .numero(entity.getNumero())
                .ville_exertion(entity.getVille_exertion())
                .type_contrat(entity.getType_contrat())
                .date_debut(entity.getDate_debut())
                .date_fin(entity.getDate_fin())
                .statut_matrimoniale(entity.getStatut_matrimoniale())
                .profession(entity.getProfession())
                .username(entity.getUsername())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .statut(entity.getStatut())
                .nbConges(entity.getNbConges())
               //.sanctions(SanctionResponseDTO.buildFromEntityList(sanctionList))
                //.congers(CongerResponseDTO.buildFromEntity(congerList))

                .build();
    }

 public  static EmployerResponseDTO buildFromEntitySa(Employer entity, List<Sanction> sanctionList, List<Conger> congerList){
  return EmployerResponseDTO.builder()
          .id(entity.getId())
          .codeEmployer(entity.getCodeEmployer())
          .nom(entity.getNom())
          .prenom(entity.getPrenom())
          .adresse(entity.getAdresse())
          .date_naissance(entity.getDate_naissance())
          .lieu_naissance(entity.getLieu_naissance())
          .matricule(entity.getMatricule())
          .photo(entity.getPhoto())
          .nationalite(entity.getNationalite())
          .nbr_enfant(entity.getNbr_enfant())
          .poste(entity.getPoste())
          .sexe(entity.getSexe())
          .numero(entity.getNumero())
          .ville_exertion(entity.getVille_exertion())
          .type_contrat(entity.getType_contrat())
          .date_debut(entity.getDate_debut())
          .date_fin(entity.getDate_fin())
          .statut_matrimoniale(entity.getStatut_matrimoniale())
          .profession(entity.getProfession())
          .username(entity.getUsername())
          .username(entity.getUsername())
          .password(entity.getPassword())
          .statut(entity.getStatut())
          .nbConges(entity.getNbConges())
          .sanctions(SanctionResponseDTO.buildFromEntityList(sanctionList))
          .congers(CongerResponseDTO.buildFromEntity(congerList))

          .build();
 }

    public static List <EmployerResponseDTO> builFromEntityList(List <Employer> employerList ){
        return employerList.stream().map(EmployerResponseDTO::buildFromEntity).collect(Collectors.toList());

    }

 public static Page<EmployerResponseDTO> buildFromEntityPage( Page<Employer> entityList) {
  return entityList.map(EmployerResponseDTO::buildFromEntity);
 }

    public static User buildFromEntityUser(EmployerResponseDTO entity, Employer employer){
        return User.UserBuilder.anUser()
                .username(entity.getUsername())
                .password(GeneralUtils.genererPasswordUser(entity.getPassword()))
                .employer(employer)
                .build();
    }
}
