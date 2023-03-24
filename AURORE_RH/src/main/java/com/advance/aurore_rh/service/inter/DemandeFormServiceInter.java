package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.DemandeFormRequestDTO;
import com.advance.aurore_rh.dto.response.DemandeFormResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DemandeFormServiceInter {

    DemandeFormResponseDTO createDemande(DemandeFormRequestDTO demandeFormRequestDTO) ;

    Page<DemandeFormResponseDTO> getAllDemande(String token, Pageable pageable);

    DemandeFormResponseDTO getDemandeById(Long id);

    String deleteDemande(Long id );
}
