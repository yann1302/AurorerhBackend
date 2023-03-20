package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.FormationRequestDTO;
import com.advance.aurore_rh.dto.response.FormationResponseDTO;

import java.util.List;

public interface FormationServiceInter {

    FormationResponseDTO creteForm(FormationRequestDTO formationRequestDTO);

    List<FormationResponseDTO> getAllForm();

    FormationResponseDTO getFormById(Long id);

    String deleteForm(Long id);
}
