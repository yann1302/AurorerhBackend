package com.advance.aurore_rh.service.inter;

import com.advance.aurore_rh.dto.request.TypeCongerRequestDTO;
import com.advance.aurore_rh.dto.request.TypeContratRequestDTO;
import com.advance.aurore_rh.dto.response.TypeCongerResponseDTO;
import com.advance.aurore_rh.dto.response.TypeContratResponseDTO;

import java.util.List;

public interface TypeCongerServiceInter {

    TypeCongerResponseDTO createTypCong(TypeCongerRequestDTO typeCongerRequestDTO);

    List<TypeCongerResponseDTO> getAllTypCong();

    TypeCongerResponseDTO getTypCongById(Long id);

    TypeCongerResponseDTO updateTypCongById(TypeCongerRequestDTO typeCongerRequestDTO);

    String deleteTypCongById(Long id);
}
