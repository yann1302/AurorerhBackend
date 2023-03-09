package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import com.advance.aurore_rh.model.Employer;

import java.util.*;

public interface EmployerServiceinter {

    EmployerResponseDTO createEmpl(EmployerRequestDTO employerRequestDTO);

    List<EmployerResponseDTO> getAllEmpl();

    EmployerResponseDTO getEmplById(Long Id);

    EmployerResponseDTO updateEmpl(EmployerRequestDTO employerRequestDTO);

    String deleteById(Long id);





}
