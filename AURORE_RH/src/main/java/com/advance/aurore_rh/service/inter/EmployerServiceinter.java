package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.dto.request.UserEmployerRequestDTO;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployerServiceinter {

    EmployerResponseDTO createEmpl(UserEmployerRequestDTO userEmployerRequestDTO);

    Page<EmployerResponseDTO> getAllEmpl(String token,String statut, Pageable pageable);

    EmployerResponseDTO getEmplById(Long Id);

    EmployerResponseDTO updateEmpl(EmployerRequestDTO employerRequestDTO);

    String deleteById(Long id);





}
