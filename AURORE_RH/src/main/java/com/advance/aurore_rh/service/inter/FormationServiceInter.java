package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.FormationRequestDTO;
import com.advance.aurore_rh.dto.response.FormationResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FormationServiceInter {

    FormationResponseDTO creteForm(FormationRequestDTO formationRequestDTO);

    Page<FormationResponseDTO> getAllForm(String token, Pageable pageable);

    FormationResponseDTO getFormById(Long id);

    String deleteForm(Long id);
}
