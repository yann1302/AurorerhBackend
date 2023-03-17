package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.dto.request.UserEmployerRequestDTO;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import com.advance.aurore_rh.exceptions.BadRequestException;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Numerotation;
import com.advance.aurore_rh.model.User;
import com.advance.aurore_rh.repository.*;
import com.advance.aurore_rh.service.inter.EmployerServiceinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service

public class EmployerServiceEmpl implements EmployerServiceinter {


    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    SanctionRepository sanctionRepository;

    @Autowired
    ContratRepository contratRepository;

    @Autowired
    CongerRepository congerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NumerotationRepository numerotationRepository;

    @Override
    public EmployerResponseDTO createEmpl(UserEmployerRequestDTO userEmployerRequestDTO) {
        if(Objects.nonNull(userEmployerRequestDTO.getId()) &&  userEmployerRequestDTO.getId() > 0 ){
            Employer employerToSave = employerRepository.findById(userEmployerRequestDTO.getId())
                    .map( e -> {
                        e.setNom(userEmployerRequestDTO.getNom());
                        e.setPrenom(userEmployerRequestDTO.getPrenom());
                        e.setPhoto(userEmployerRequestDTO.getPhoto());
                        e.setDate_naissance(userEmployerRequestDTO.getDate_naissance());
                        e.setLieu_naissance(userEmployerRequestDTO.getLieu_naissance());
                        e.setStatut_matrimoniale(userEmployerRequestDTO.getStatut_matrimoniale());
                        e.setSexe(userEmployerRequestDTO.getSexe());
                        e.setNbr_enfant(userEmployerRequestDTO.getNbr_enfant());
                        e.setNumero(userEmployerRequestDTO.getNumero());
                        e.setType_contrat(userEmployerRequestDTO.getType_contrat());
                        e.setDate_debut(userEmployerRequestDTO.getDate_debut());
                        e.setAdresse(userEmployerRequestDTO.getAdresse());
                        e.setDate_fin(userEmployerRequestDTO.getDate_fin());
                        e.setMatricule(userEmployerRequestDTO.getMatricule());
                        e.setPoste(userEmployerRequestDTO.getPoste());
                        e.setProfession(userEmployerRequestDTO.getProfession());
                        e.setVille_exertion(userEmployerRequestDTO.getVille_exertion());
                        //e.setSanctions(userEmployerRequestDTO.getSanctions());
                        return employerRepository.save(e);}
                    ).orElseThrow(()->new RuntimeException("Aucun employé trouvé"));
            return EmployerResponseDTO.buildFromEntity(employerToSave);
        }
        //userEmployerRequestDTO.setCodeEmployer(getCodeCourant());
        Employer e = employerRepository.save(userEmployerRequestDTO.buildFromDtoEmployer(userEmployerRequestDTO));
        Employer employerToSave = employerRepository.findById(e.getId()).orElseThrow(()->new RuntimeException("Aucun employé trouvé"));

        User u = userRepository.save(userEmployerRequestDTO.buildFromDtoUser(userEmployerRequestDTO, e));
        return EmployerResponseDTO.buildFromEntity(employerToSave) ;


    }

   // @Transactional
   // public String getCodeCourant() {
  //      Numerotation numerotation = numerotationRepository.findByCode("CODE_EMPLOYE").orElse(null);
   //     if (Objects.isNull(numerotation))
   //         throw new BadRequestException(HttpStatus.BAD_REQUEST, "Configuration requise", "aucune configuration n'as ete definir pour la souche de numérotation de : CODE_EMPLOYE");
   //     //assert numerotation != null;
   //     int fin = numerotation.getSouche().indexOf("00");
    //    String codeUser, prefix = ((fin > 0) ? numerotation.getSouche().substring(0, fin) : numerotation.getSouche());
     //   codeUser = prefix.concat(new DecimalFormat("00000").format(numerotation.getNumeroIndex())).toUpperCase();
//
      //  while (employerRepository.existsByCodeEmployer(codeUser)) {
      //      numerotation.setNumeroIndex(numerotation.getNumeroIndex() + 1);
        //    Optional<Numerotation> numerotation2 = numerotationRepository.findById(numerotation.getId());
        //    numerotation.setNumeroIndex(numerotation.getNumeroIndex());
         //   //assert numerotation2 != null;
         //   numerotation = numerotationRepository.save(numerotation2.get());

        //    codeUser = prefix.concat(new DecimalFormat("00000").format(numerotation.getNumeroIndex())).toUpperCase();
       // }

      //  return codeUser;
   // }

    @Override
    public List<EmployerResponseDTO> getAllEmpl() {
        return EmployerResponseDTO.builFromEntityList(employerRepository.findAll());
    }

    @Override
    public EmployerResponseDTO getEmplById(Long id) {
        return EmployerResponseDTO.buildFromEntity(employerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Aucun employer trouvé")));

    }

    @Override
    public EmployerResponseDTO updateEmpl(EmployerRequestDTO userEmployerRequestDTO) {
        Employer employerToSave = employerRepository.findById(userEmployerRequestDTO.getId())
                .map( e -> {
                    e.setNom(userEmployerRequestDTO.getNom());
                    e.setPrenom(userEmployerRequestDTO.getPrenom());
                    e.setPhoto(userEmployerRequestDTO.getPhoto());
                    e.setDate_naissance(userEmployerRequestDTO.getDate_naissance());
                    e.setLieu_naissance(userEmployerRequestDTO.getLieu_naissance());
                    e.setStatut_matrimoniale(userEmployerRequestDTO.getStatut_matrimoniale());
                    e.setSexe(userEmployerRequestDTO.getSexe());
                    e.setNbr_enfant(userEmployerRequestDTO.getNbr_enfant());
                    e.setNumero(userEmployerRequestDTO.getNumero());
                    e.setType_contrat(userEmployerRequestDTO.getType_contrat());
                    e.setDate_debut(userEmployerRequestDTO.getDate_debut());
                    e.setAdresse(userEmployerRequestDTO.getAdresse());
                    e.setDate_fin(userEmployerRequestDTO.getDate_fin());
                    e.setMatricule(userEmployerRequestDTO.getMatricule());
                    e.setPoste(userEmployerRequestDTO.getPoste());
                    e.setProfession(userEmployerRequestDTO.getProfession());
                    e.setVille_exertion(userEmployerRequestDTO.getVille_exertion());
                    //e.setSanctions(userEmployerRequestDTO.getSanctions());
                    return employerRepository.save(e);}
                ).orElseThrow(()->new RuntimeException("Aucun employer trouvé"));
        return EmployerResponseDTO.buildFromEntity(employerToSave);
    }

    @Override
    public String deleteById(Long id) {
       if ( sanctionRepository.existsByEmployerId(id) || contratRepository.existsByEmployerId(id) || congerRepository.existsByEmployerId(id))
           throw new RuntimeException("cette employer a un contrat ou une sanction ");
    employerRepository.deleteById(id);
        return  "Employer Supprimé";
    }
}
