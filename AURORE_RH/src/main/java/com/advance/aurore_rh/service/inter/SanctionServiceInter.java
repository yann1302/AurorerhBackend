package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.SanctionRequetDTO;
import com.advance.aurore_rh.dto.response.SanctionResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SanctionServiceInter {
    SanctionResponseDTO creatsanct(SanctionRequetDTO sanctionRequetDTO);

    Page<SanctionResponseDTO> getAllsanct(String token, Pageable pageable);

    SanctionResponseDTO getSanctById(Long id);

    SanctionResponseDTO updateSanct(SanctionRequetDTO sanctionRequetDTO);

    String deletesanctById(Long id);
}
