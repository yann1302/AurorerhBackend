package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.StagiaireRequestDTO;
import com.advance.aurore_rh.dto.response.StagiaireResponseDTO;
import com.advance.aurore_rh.model.Sanction;
import com.advance.aurore_rh.model.Stagiaire;
import com.advance.aurore_rh.repository.StagiaireRepository;
import com.advance.aurore_rh.service.inter.StagiaireServiceInter;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StagiaireServiceEmpl implements StagiaireServiceInter {

    @Autowired
    StagiaireRepository stagiaireRepository;

    @Override
    public StagiaireResponseDTO creatStag(StagiaireRequestDTO stagiaireRequestDTO) {
        Stagiaire s = stagiaireRequestDTO.buildFromDto(stagiaireRequestDTO);
        return StagiaireResponseDTO.buildFromEntity(stagiaireRepository.save(s));
    }

    @Override
    public List<StagiaireResponseDTO> getAllStag() {
        return StagiaireResponseDTO.builFromEntityList(stagiaireRepository.findAll());
    }

    @Override
    public StagiaireResponseDTO getStagById(Long id) {
        return StagiaireResponseDTO.buildFromEntity(stagiaireRepository.findById(id)
                .orElseThrow(()->new RuntimeException("aucun stagiaire trouvé ")));
    }

    @Override
    public String deleteStagById(Long id) {
        stagiaireRepository.deleteById(id);
        return "saction supprimé";
    }
}
