package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.NoteProfessionelRequestDTO;
import com.advance.aurore_rh.dto.response.NoteProfessionelResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteProfessionelServiceInter {

    NoteProfessionelResponseDTO createEmpl(NoteProfessionelRequestDTO noteProfessionelRequestDTO);

    Page<NoteProfessionelResponseDTO> getAllEmpl(String token, Pageable pageable);

    NoteProfessionelResponseDTO getEmplById(Long Id);

    String deleteById(Long id);
}
