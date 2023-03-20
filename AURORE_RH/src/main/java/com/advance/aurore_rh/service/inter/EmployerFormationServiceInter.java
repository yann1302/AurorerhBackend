package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.EmployerFormationRequestDTO;
import com.advance.aurore_rh.dto.response.EmployerFormationResponseDTO;

import java.util.List;

public interface EmployerFormationServiceInter {

    EmployerFormationResponseDTO createEmplForm(EmployerFormationRequestDTO employerFormationRequestDTO);

    List<EmployerFormationResponseDTO> getAllEmplForm();

    EmployerFormationResponseDTO getEmplFormById(Long Id);

    String deleteEmplForm(Long id);
}
