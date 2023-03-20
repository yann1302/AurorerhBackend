package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.EmployerFormationRequestDTO;
import com.advance.aurore_rh.dto.response.EmployerFormationResponseDTO;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.repository.FormationRepository;
import com.advance.aurore_rh.repository.lnk.EmployerFormationRepository;
import com.advance.aurore_rh.service.inter.EmployerFormationServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor

public class EmployerFormationServiceEmpl implements EmployerFormationServiceInter {
    @Autowired
    EmployerFormationRepository employerFormationRepository;

    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    FormationRepository formationRepository;

    @Override
    public EmployerFormationResponseDTO createEmplForm(EmployerFormationRequestDTO employerFormationRequestDTO) {
        if(Objects.nonNull(employerFormationRequestDTO.getId()) &&  employerFormationRequestDTO.getId() > 0 ){
            EmployerFormation employerFormationToSave = employerFormationRepository.findById(employerFormationRequestDTO.getId())
                    .map(ef -> {
                        ef.setDebut_form(employerFormationRequestDTO.getDebut_form());
                        ef.setFin_form(employerFormationRequestDTO.getFin_form());
                        ef.setDescription(employerFormationRequestDTO.getDescription());
                        ef.setFormateur(employerFormationRequestDTO.getFormateur());
                        return employerFormationRepository.save(ef);
                    }).orElseThrow(()->new RuntimeException("Aucune formation trouvé trouvé"));
            return EmployerFormationResponseDTO.buildFromEntity(employerFormationToSave);
        }

        Employer employer = employerRepository.findById(employerFormationRequestDTO.getEmployer_id())
                .orElseThrow(() -> new RuntimeException("Aucun employer trouvé avec cette id"));

        Formation formation = formationRepository.findById(employerFormationRequestDTO.getFormation_id())
                .orElseThrow(() -> new RuntimeException("Aucune formation trouvée avec cette id"));

        EmployerFormation employerFormation = employerFormationRequestDTO.buildFromDto(employerFormationRequestDTO, employer, formation );
        return EmployerFormationResponseDTO.buildFromEntity(employerFormationRepository.save(employerFormation));
    }

    @Override
    public List<EmployerFormationResponseDTO> getAllEmplForm() {
        return EmployerFormationResponseDTO.buildFromEntity(employerFormationRepository.findAll());
    }

    @Override
    public EmployerFormationResponseDTO getEmplFormById(Long Id) {
        return EmployerFormationResponseDTO.buildFromEntity(employerFormationRepository.findById(Id)
                .orElseThrow(()->new RuntimeException("Aucun contrat trouvé")));
    }


    @Override
    public String deleteEmplForm(Long id) {
        employerFormationRepository.deleteById(id);
        return "employé formation suprimé";
    }
}
