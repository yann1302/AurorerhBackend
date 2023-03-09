package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.CongerRequestDTO;
import com.advance.aurore_rh.dto.response.CongerResponseDTO;

import java.util.List;

public interface CongerServiceInter {
    CongerResponseDTO createConger(CongerRequestDTO congerRequestDTO);

    List<CongerResponseDTO> getAllConger();

    CongerResponseDTO getCongetById(Long id);

    String deleteCongerById(Long id);
}
