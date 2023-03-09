package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.repository.SanctionRepository;
import com.advance.aurore_rh.service.inter.EmployerServiceinter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class EmployerServiceEmpl implements EmployerServiceinter {


    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    SanctionRepository sanctionRepository;

    @Override
    public EmployerResponseDTO createEmpl(EmployerRequestDTO employerRequestDTO) {

        Employer e = employerRequestDTO.buildFromDto(employerRequestDTO);
        return EmployerResponseDTO.buildFromEntity(employerRepository.save(e));

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
