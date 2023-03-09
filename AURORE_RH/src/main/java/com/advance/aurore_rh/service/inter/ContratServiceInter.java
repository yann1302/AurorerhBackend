package com.advance.aurore_rh.service.inter;



import com.advance.aurore_rh.dto.request.ContratRequestDTO;
import com.advance.aurore_rh.dto.response.ContratResponseDTO;

import java.util.List;

public interface ContratServiceInter {

    ContratResponseDTO createcontrat(ContratRequestDTO contratRequestDTO );

    List<ContratResponseDTO> getAllcontr();

    ContratResponseDTO getcontrById(Long Id);

    ContratResponseDTO updateContr(ContratRequestDTO contratRequestDTO);

    String deleteContrById(Long id);
}
