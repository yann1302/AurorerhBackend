package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.CongerRequestDTO;
import com.advance.aurore_rh.dto.response.CongerResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CongerServiceInter {
    CongerResponseDTO createConger(CongerRequestDTO congerRequestDTO);

    Page<CongerResponseDTO> getAllConger(String token, Pageable pageable);

    CongerResponseDTO getCongetById(Long id);

    String deleteCongerById(Long id);
}
