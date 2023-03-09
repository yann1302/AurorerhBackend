package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.SanctionRequetDTO;
import com.advance.aurore_rh.dto.response.SanctionResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SanctionServiceInter {
    SanctionResponseDTO creatsanct(SanctionRequetDTO sanctionRequetDTO);

    List<SanctionResponseDTO> getAllsanct();

    SanctionResponseDTO getSanctById(Long id);

    SanctionResponseDTO updateSanct(SanctionRequetDTO sanctionRequetDTO);

    String deletesanctById(Long id);
}
