package com.advance.aurore_rh.service.inter;


import com.advance.aurore_rh.dto.request.TypeContratRequestDTO;
import com.advance.aurore_rh.dto.response.TypeContratResponseDTO;


import java.util.List;

public interface TypeContratServiceInter  {


    TypeContratResponseDTO createTypCon(TypeContratRequestDTO typeContratRequestDTO);

    List<TypeContratResponseDTO> getAllTypCon();

    TypeContratResponseDTO getTypConById(Long id);

    TypeContratResponseDTO updateTypConById(TypeContratRequestDTO typeContratRequestDTO);

    String deleteTypConById(Long id);

}
