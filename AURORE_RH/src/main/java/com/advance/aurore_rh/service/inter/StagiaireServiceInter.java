package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.StagiaireRequestDTO;
import com.advance.aurore_rh.dto.response.StagiaireResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StagiaireServiceInter {
    StagiaireResponseDTO creatStag(StagiaireRequestDTO stagiaireRequestDTO);

    Page<StagiaireResponseDTO> getAllStag(String token, Pageable pageable);

    StagiaireResponseDTO getStagById(Long id);

    String deleteStagById(Long id);
}
