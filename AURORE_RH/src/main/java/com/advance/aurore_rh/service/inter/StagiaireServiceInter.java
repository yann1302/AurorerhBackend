package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.StagiaireRequestDTO;
import com.advance.aurore_rh.dto.response.StagiaireResponseDTO;

import java.util.List;

public interface StagiaireServiceInter {
    StagiaireResponseDTO creatStag(StagiaireRequestDTO stagiaireRequestDTO);

    List<StagiaireResponseDTO> getAllStag();

    StagiaireResponseDTO getStagById(Long id);

    String deleteStagById(Long id);
}
