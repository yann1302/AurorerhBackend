package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.EmployerFormationRequestDTO;
import com.advance.aurore_rh.dto.response.EmployerFormationResponseDTO;
import com.advance.aurore_rh.dto.response.SessionsFormationResponseDTO;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Formation;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.repository.FormationRepository;
import com.advance.aurore_rh.repository.lnk.EmployerFormationRepository;
import com.advance.aurore_rh.service.inter.EmployerFormationServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        String reference = employerFormationRequestDTO.getReference();

            if(Objects.nonNull(employerFormationRequestDTO.getReference()) && employerFormationRequestDTO.getReference().equals(reference)
            ){
                employerFormationRepository.findByReference(employerFormationRequestDTO.getReference())
                        .stream()
                        .map(ef -> {
                            ef.setDebut_form(employerFormationRequestDTO.getDebut_form());
                            ef.setFin_form(employerFormationRequestDTO.getFin_form());
                            ef.setDescription(employerFormationRequestDTO.getDescription());
                            ef.setFormateur(employerFormationRequestDTO.getFormateur());
                            return employerFormationRepository.save(ef);
                        });

                return getEmplFormByReference(employerFormationRequestDTO.getReference());
              // return EmployerFormationResponseDTO.buildFromEntity(employerFormationToSave);
            }

            Formation formation = formationRepository.findById(employerFormationRequestDTO.getFormation_id())
                    .orElseThrow(() -> new RuntimeException("Aucune formation trouvée avec cette id"));
            //employerFormationRequestDTO.setReference();

            employerFormationRequestDTO.getEmployers().forEach(employerId->{
                Employer employer = employerRepository.findById(employerId)
                        .orElseThrow(() -> new RuntimeException("Aucun employer trouvé avec cette id"));
                EmployerFormation employerFormation = employerFormationRequestDTO.buildFromDto(employerFormationRequestDTO, employer, formation );
                employerFormationRepository.save(employerFormation);
            });
        return getEmplFormByReference(employerFormationRequestDTO.getReference());
    }


    @Override
    public List<SessionsFormationResponseDTO> getAllEmplForm() {
        return  employerFormationRepository.countEmployersPerFormation1();
    }

    @Override
//    public EmployerFormationResponseDTO getEmplFormByReference(String reference) {
//                List <Employer> employers = new ArrayList<>();
//        List <EmployerFormation> employerFormation = employerFormationRepository.findByReference(reference);
//        employerFormation.forEach(employerFormation1 -> {
//            employers.add(employerFormation1.getEmployer());
//        });
//        return EmployerFormationResponseDTO.buildFromEntity(employerFormation.get(0), employers);
////                EmployerFormationResponseDTO.buildFromEntity(employerFormationRepository.findById(Id)
////                .orElseThrow(()->new RuntimeException("Aucun contrat trouvé")));
    public EmployerFormationResponseDTO getEmplFormByReference(String reference) {
        List<Employer> employers = new ArrayList<>();
        List<EmployerFormation> employerFormation = employerFormationRepository.findByReference(reference);
        if (employerFormation.size() > 0) {
            employerFormation.forEach(employerFormation1 -> {
                employers.add(employerFormation1.getEmployer());
            });
            return EmployerFormationResponseDTO.buildFromEntity(employerFormation.get(0), employers);
        }
        throw new RuntimeException("Aucun employé trouvé avec cette référence");
    }

    @Override
    @Transactional
    public String deleteEmplForm(String reference) {
        employerFormationRepository.deleteByReference(reference);
        return "Session suprimé";
    }
}
