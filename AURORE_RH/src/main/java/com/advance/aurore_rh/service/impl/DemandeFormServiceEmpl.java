package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.DemandeFormRequestDTO;
import com.advance.aurore_rh.dto.response.DemandeFormResponseDTO;
import com.advance.aurore_rh.model.DemandeForm;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.repository.DemandeFormRepository;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.repository.FormationRepository;
import com.advance.aurore_rh.service.inter.DemandeFormServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class DemandeFormServiceEmpl implements DemandeFormServiceInter {

    @Autowired
    DemandeFormRepository demandeFormRepository;

    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    FormationRepository formationRepository;


    @Override
    public DemandeFormResponseDTO createDemande(DemandeFormRequestDTO demandeFormRequestDTO) {

        if(Objects.nonNull(demandeFormRequestDTO.getId()) &&  demandeFormRequestDTO.getId() > 0 ){
            DemandeForm demandeFormToSave = demandeFormRepository.findById(demandeFormRequestDTO.getId())
                    .map( c -> {
                        c.setDate_demande(demandeFormRequestDTO.getDate_demande());
                        c.setStatut(demandeFormRequestDTO.getStatut());
                        return  demandeFormRepository.save(c);}
                    ).orElseThrow(()->new RuntimeException("Aucune demande trouvé"));
            return DemandeFormResponseDTO.buildFromEntity(demandeFormToSave);

        }
        Employer employer = employerRepository.findById(demandeFormRequestDTO.getId_Employer())
                .orElseThrow(() -> new RuntimeException("Aucun employer trouvé avec cette id"));

        Formation formation = formationRepository.findById(demandeFormRequestDTO.getId_Formation())
                .orElseThrow(() -> new RuntimeException("Aucune formation trouvé avec cette id"));
        DemandeForm c = demandeFormRequestDTO.buildFromDTO(demandeFormRequestDTO, employer, formation);

        return DemandeFormResponseDTO.buildFromEntity(demandeFormRepository.save(c));
    }

    @Override
    public Page<DemandeFormResponseDTO> getAllDemande(String token, Pageable pageable) {
        return DemandeFormResponseDTO.buildFromEntityPage(demandeFormRepository.findAllByToken('%'+token+'%', pageable));
    }

    @Override
    public DemandeFormResponseDTO getDemandeById(Long id) {
        return DemandeFormResponseDTO.buildFromEntity(demandeFormRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Aucune demande trouvée")));

    }

    @Override
    public String deleteDemande(Long id) {
        demandeFormRepository.deleteById(id);
        return "demande suprimée";
    }
}
