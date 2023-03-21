package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.DemandeFormRequestDTO;
import com.advance.aurore_rh.dto.response.DemandeFormResponseDTO;

import java.util.List;

public interface DemandeFormServiceInter {

    DemandeFormResponseDTO createDemande(DemandeFormRequestDTO demandeFormRequestDTO) ;

    List<DemandeFormResponseDTO > getAllDemande();

    DemandeFormResponseDTO getDemandeById(Long id);

    String deleteDemande(Long id );
}
