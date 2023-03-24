package com.advance.aurore_rh.service.inter;



import com.advance.aurore_rh.dto.request.ContratRequestDTO;
import com.advance.aurore_rh.dto.response.ContratResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContratServiceInter {

    ContratResponseDTO createcontrat(ContratRequestDTO contratRequestDTO );

    Page<ContratResponseDTO> getAllcontr(String token, Pageable pageable);

    ContratResponseDTO getcontrById(Long Id);

    ContratResponseDTO updateContr(ContratRequestDTO contratRequestDTO);

    String deleteContrById(Long id);
}
