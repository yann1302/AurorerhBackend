package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.dto.request.NoteProfessionelRequestDTO;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import com.advance.aurore_rh.dto.response.NoteProfessionelResponseDTO;

import java.util.List;

public interface NoteProfessionelServiceInter {

    NoteProfessionelResponseDTO createEmpl(NoteProfessionelRequestDTO noteProfessionelRequestDTO);

    List<NoteProfessionelResponseDTO> getAllEmpl();

    NoteProfessionelResponseDTO getEmplById(Long Id);

    String deleteById(Long id);
}
