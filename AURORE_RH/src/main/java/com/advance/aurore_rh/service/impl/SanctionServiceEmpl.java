package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.SanctionRequetDTO;
import com.advance.aurore_rh.dto.response.SanctionResponseDTO;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Sanction;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.repository.SanctionRepository;
import com.advance.aurore_rh.service.inter.SanctionServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class SanctionServiceEmpl implements SanctionServiceInter {


    @Autowired
    SanctionRepository sanctionRepository;
    @Autowired
    EmployerRepository employerRepository;

    @Override
    public SanctionResponseDTO creatsanct(SanctionRequetDTO sanctionRequetDTO) {
        Employer employer = employerRepository.findById(sanctionRequetDTO.getId_Employer())
        .orElseThrow(() -> new RuntimeException("Aucun employer trouvé avec cette id"));
        Sanction s = sanctionRequetDTO.buildFromDto(sanctionRequetDTO, employer);
        return SanctionResponseDTO.buildFromEntity(sanctionRepository.save(s));
    }

    @Override
    public List<SanctionResponseDTO> getAllsanct() {
        return SanctionResponseDTO.buildFromEntityList(sanctionRepository.findAll());
    }

    @Override
    public SanctionResponseDTO getSanctById(Long id) {
       return SanctionResponseDTO.buildFromEntity(sanctionRepository.findById(id)
               .orElseThrow(()->new RuntimeException("Aucune santion trouvé")));

    }

    @Override
    public SanctionResponseDTO updateSanct(SanctionRequetDTO sanctionRequetDTO) {
        Sanction sanctionToSave = sanctionRepository.findById(sanctionRequetDTO.getId())
                .map(s -> {
                    s.setDebut_sanction(sanctionRequetDTO.getDebut_sanction());
                    s.setFin_sanction(sanctionRequetDTO.getFin_sanction());
                    s.setDescription(sanctionRequetDTO.getDescription());
                    s.setType_sanction(sanctionRequetDTO.getType_sanction());
                    return sanctionRepository.save(s);

                }).orElseThrow(()->new RuntimeException("Aucun contrat trouvé"));
        return SanctionResponseDTO.buildFromEntity(sanctionToSave);

    }

    @Override
    public String deletesanctById(Long id) {
        sanctionRepository.deleteById(id);
        return "sanction supprimé";
    }
}
