package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.dto.request.UserEmployerRequestDTO;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Numerotation;
import com.advance.aurore_rh.model.User;
import com.advance.aurore_rh.repository.*;
import com.advance.aurore_rh.service.inter.EmployerServiceinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


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
        userEmployerRequestDTO.setCodeEmployer(getCodeCourant());
        Employer e = employerRepository.save(userEmployerRequestDTO.buildFromDtoEmployer(userEmployerRequestDTO));
        Employer employerToSave = employerRepository.findById(e.getId()).orElseThrow(()->new RuntimeException("Aucun employé trouvé"));

        User u = userRepository.save(userEmployerRequestDTO.buildFromDtoUser(userEmployerRequestDTO, e));
        return EmployerResponseDTO.buildFromEntity(employerToSave) ;

    }


    public String getCodeCourant() {
        Numerotation numerotation = numerotationRepository.findByCode("CODE_EMPLOYE").orElse(null);
        if (Objects.isNull(numerotation)) {
            // Si la souche de numérotation n'existe pas, créer une nouvelle souche avec un numéro d'index initial de 1
            numerotation = new Numerotation();
            numerotation.setCode("CODE_EMPLOYE");
            numerotation.setSouche("EMPL");
            numerotation.setNumeroIndex(1L);
            numerotationRepository.save(numerotation);
        }
        // Récupérer la souche et le numéro d'index courants
        String souche = numerotation.getSouche();
        Long numeroIndex = numerotation.getNumeroIndex();
        // Générer le code avec la souche et le numéro d'index courants
        String code = souche.concat(String.format("%05d", numeroIndex));
        // Vérifier si le code existe déjà dans la base de données
        while (employerRepository.existsByCodeEmployer(code)) {
            // Si le code existe, incrémenter le numéro d'index et générer un nouveau code
            numeroIndex++;
            numerotation.setNumeroIndex(numeroIndex);
            numerotation = numerotationRepository.save(numerotation);
            code = souche.concat(String.format("%05d", numeroIndex));
        }
        // Retourner le code généré
        return code;
    }

    @Override
    public Page<EmployerResponseDTO> getAllEmpl(String token, Pageable pageable) {
        return EmployerResponseDTO.buildFromEntityPage(employerRepository.findAllByToken('%'+token+'%', pageable));
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

    @Transactional
    @Override
    public String deleteById(Long id) {
        // vérifier si l'employé a des contrats, des sanctions ou des congés
        boolean hasContracts = contratRepository.existsByEmployerId(id);
        boolean hasSanctions = sanctionRepository.existsByEmployerId(id);
        boolean hasConges = congerRepository.existsByEmployerId(id);

        // Si l'employé a des contrats, des sanctions ou des congés, supprimer ces entités avant de supprimer l'employé lui-même
        if (hasContracts) {
            contratRepository.deleteByEmployerId(id);
        }
        if (hasSanctions) {
            sanctionRepository.deleteByEmployerId(id);
        }
        if (hasConges) {
            congerRepository.deleteByEmployerId(id);
        }
        // Supprimer l'employé
        userRepository.deleteById(id);
        employerRepository.deleteById(id);

        return "Employé et ses contrats, sanctions et congés supprimés avec succès";
    }

}
