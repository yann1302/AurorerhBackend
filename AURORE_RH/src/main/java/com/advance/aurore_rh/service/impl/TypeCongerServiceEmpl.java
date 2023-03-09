package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.TypeCongerRequestDTO;
import com.advance.aurore_rh.dto.request.TypeContratRequestDTO;
import com.advance.aurore_rh.dto.response.TypeCongerResponseDTO;
import com.advance.aurore_rh.dto.response.TypeContratResponseDTO;
import com.advance.aurore_rh.model.TypeConger;
import com.advance.aurore_rh.model.TypeContrat;
import com.advance.aurore_rh.repository.TypeCongerRepository;
import com.advance.aurore_rh.repository.TypeContratRepository;
import com.advance.aurore_rh.service.inter.TypeCongerServiceInter;
import com.advance.aurore_rh.service.inter.TypeContratServiceInter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TypeCongerServiceEmpl implements TypeCongerServiceInter {

    @Autowired
    TypeCongerRepository typeCongerRepository;


    @Override
    public TypeCongerResponseDTO createTypCong(TypeCongerRequestDTO typeCongerRequestDTO) {

        TypeConger tg = typeCongerRequestDTO.buildFromDto(typeCongerRequestDTO);
        return TypeCongerResponseDTO.buildFromEntity(typeCongerRepository.save(tg));
    }

    @Override
    public List<TypeCongerResponseDTO> getAllTypCong() {
        return TypeCongerResponseDTO.buildFromEntityList(typeCongerRepository.findAll());
    }

    @Override
    public TypeCongerResponseDTO getTypCongById(Long id) {
        return null;
    }

    @Override
    public TypeCongerResponseDTO updateTypCongById(TypeCongerRequestDTO typeCongerRequestDTO) {
        return null;
    }

    @Override
    public String deleteTypCongById(Long id) {
        return null;
    }
}
