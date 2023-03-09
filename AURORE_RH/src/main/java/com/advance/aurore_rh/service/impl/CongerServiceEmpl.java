package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.CongerRequestDTO;
import com.advance.aurore_rh.dto.response.CongerResponseDTO;
import com.advance.aurore_rh.dto.response.SanctionResponseDTO;
import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.repository.CongerRepository;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.service.inter.CongerServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class CongerServiceEmpl implements CongerServiceInter {

    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    CongerRepository congerRepository;

    @Override
    public CongerResponseDTO createConger(CongerRequestDTO congerRequestDTO) {
        Employer employer = employerRepository.findById(congerRequestDTO.getId_Employer())
                .orElseThrow(() -> new RuntimeException("Aucun employer trouvé avec cette id"));
        Conger c =congerRequestDTO.buildFromDto(congerRequestDTO, employer);
        return CongerResponseDTO.buildFromEntity(congerRepository.save(c));
    }

    @Override
    public List<CongerResponseDTO> getAllConger() {
        return CongerResponseDTO.buildFromEntity(congerRepository.findAll());
    }

    @Override
    public CongerResponseDTO getCongetById(Long id) {
        return CongerResponseDTO.buildFromEntity(congerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Aucune santion trouvé")));

    }

    @Override
    public String deleteCongerById(Long id) {
        congerRepository.deleteById(id);
        return "conger supprimé";
    }
}
