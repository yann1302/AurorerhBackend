package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.FormationRequestDTO;
import com.advance.aurore_rh.dto.response.FormationResponseDTO;
import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.repository.DemandeFormRepository;
import com.advance.aurore_rh.repository.FormationRepository;
import com.advance.aurore_rh.repository.lnk.EmployerFormationRepository;
import com.advance.aurore_rh.service.inter.FormationServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor



public class FormationServiceEmpl implements FormationServiceInter {

    @Autowired
    FormationRepository formationRepository;

    @Autowired
    EmployerFormationRepository employerFormationRepository;

    @Autowired
    DemandeFormRepository demandeFormRepository;

    @Override
    public FormationResponseDTO creteForm(FormationRequestDTO formationRequestDTO) {
        if(Objects.nonNull(formationRequestDTO.getId()) &&  formationRequestDTO.getId() > 0 ){
            Formation formationToSave = formationRepository.findById(formationRequestDTO.getId())
                    .map( f -> {
                        f.setDescription(formationRequestDTO.getDescription());
                        f.setDuree(formationRequestDTO.getDuree());
                        f.setTheme_form(formationRequestDTO.getTheme_form());
                        //f.setEmployerFormations(formationRequestDTO.getEmployerFormations());
                        return formationRepository.save(f);
                    } ).orElseThrow(()->new RuntimeException("Aucune formation trouvé"));
            return FormationResponseDTO.buildFromEntity(formationToSave);
        }
        Formation formation = formationRequestDTO.buildFromDto(formationRequestDTO);
        return FormationResponseDTO.buildFromEntity(formationRepository.save(formation));
    }

    @Override
    public Page<FormationResponseDTO> getAllForm(String token, Pageable pageable) {
        return FormationResponseDTO.buildFromEntityPage(formationRepository.findAllByToken('%'+token+'%', pageable));
    }

    @Override
    public FormationResponseDTO getFormById(Long id) {
        return FormationResponseDTO.buildFromEntity(formationRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Aucune formation trouvée")));
    }


    @Override
    public String deleteForm(Long id) {

        boolean hasEmployerFormation = employerFormationRepository.existsByFormationId(id);

        boolean hasDemandeForm = demandeFormRepository.existsByFormationId(id);

        if (hasEmployerFormation) {
            employerFormationRepository.deleteByFormationId(id);
        }

        if (hasDemandeForm){
            demandeFormRepository.deleteByFormationId(id);
        }

        formationRepository.deleteById(id);
        return "formation, la liste des demandes de la formation et les sessions de cette formatioon ont été suprimées";
    }
}
