package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.dto.request.UserEmployerRequestDTO;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import com.advance.aurore_rh.exceptions.BadRequestException;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Numerotation;
import com.advance.aurore_rh.model.User;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.repository.NumerotationRepository;
import com.advance.aurore_rh.repository.SanctionRepository;
import com.advance.aurore_rh.repository.UserRepository;
import com.advance.aurore_rh.service.inter.EmployerServiceinter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;


@Service

public class EmployerServiceEmpl implements EmployerServiceinter {


    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    SanctionRepository sanctionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NumerotationRepository numerotationRepository;

    @Override
    public EmployerResponseDTO createEmpl(UserEmployerRequestDTO userEmployerRequestDTO) {
        userEmployerRequestDTO.setCodeEmployer(getCodeCourant());
        Employer e = employerRepository.save(userEmployerRequestDTO.buildFromDtoEmployer(userEmployerRequestDTO));
        Employer employerToSave = employerRepository.findById(e.getId()).orElseThrow(()->new RuntimeException("Aucun employer trouvé"));

        User u = userRepository.save(userEmployerRequestDTO.buildFromDtoUser(userEmployerRequestDTO, e));
        return EmployerResponseDTO.buildFromEntity(employerToSave);

    }

    public String getCodeCourant() {
        Numerotation numerotation = numerotationRepository.findByCode("CODE_EMPLOYE").orElse(null);
        if (Objects.isNull(numerotation))
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Configuration requise", "aucune configuration n'as ete definir pour la souche de numérotation de : ARTICLE");
        //assert numerotation != null;
        int fin = numerotation.getSouche().indexOf("00");
        String codeUser, prefix = ((fin > 0) ? numerotation.getSouche().substring(0, fin) : numerotation.getSouche());
        codeUser = prefix.concat(new DecimalFormat("00000").format(numerotation.getNumeroIndex())).toUpperCase();

        while (employerRepository.existsByCodeEmployer(codeUser)) {
            numerotation.setNumeroIndex(numerotation.getNumeroIndex() + 1);
            numerotation = numerotationRepository.save(numerotation);
            codeUser = prefix.concat(new DecimalFormat("00000").format(numerotation.getNumeroIndex())).toUpperCase();
        }

        return codeUser;
    }

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
    public EmployerResponseDTO updateEmpl(EmployerRequestDTO employerRequestDTO) {
        Employer employerToSave = employerRepository.findById(employerRequestDTO.getId())
                .map( e -> {
                    e.setNom(employerRequestDTO.getNom());
                    e.setPrenom(employerRequestDTO.getPrenom());
                    e.setPhoto(employerRequestDTO.getPhoto());
                    e.setDate_naissance(employerRequestDTO.getDate_naissance());
                    e.setLieu_naissance(employerRequestDTO.getLieu_naissance());
                    e.setStatut_matrimoniale(employerRequestDTO.getStatut_matrimoniale());
                    e.setSexe(employerRequestDTO.getSexe());
                    e.setNbr_enfant(employerRequestDTO.getNbr_enfant());
                    e.setNumero(employerRequestDTO.getNumero());
                    e.setType_contrat(employerRequestDTO.getType_contrat());
                    e.setDate_debut(employerRequestDTO.getDate_debut());
                    e.setAdresse(employerRequestDTO.getAdresse());
                    e.setDate_fin(employerRequestDTO.getDate_fin());
                    e.setMatricule(employerRequestDTO.getMatricule());
                    e.setPoste(employerRequestDTO.getPoste());
                    e.setProfession(employerRequestDTO.getProfession());
                    e.setVille_exertion(employerRequestDTO.getVille_exertion());
                    //e.setSanctions(employerRequestDTO.getSanctions());
                    return employerRepository.save(e);}
                ).orElseThrow(()->new RuntimeException("Aucun employer trouvé"));
        return EmployerResponseDTO.buildFromEntity(employerToSave);
    }

    @Override
    public String deleteById(Long id) {
       if ( sanctionRepository.existsByEmployerId(id) )
           throw new RuntimeException("cette employer a une sanction");
    employerRepository.deleteById(id);
        return  "Employer Supprimé";
    }
}
