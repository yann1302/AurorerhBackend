package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.TypeContratRequestDTO;
import com.advance.aurore_rh.dto.response.TypeContratResponseDTO;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.TypeContrat;
import com.advance.aurore_rh.repository.TypeContratRepository;
import com.advance.aurore_rh.service.inter.TypeContratServiceInter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class TypeContratServiceEmpl implements TypeContratServiceInter {

    @Autowired
    TypeContratRepository typeContratRepository;

    @Override
    public TypeContratResponseDTO createTypCon(TypeContratRequestDTO typeContratRequestDTO) {

        TypeContrat tc = typeContratRequestDTO.buildFromDTO(typeContratRequestDTO);
        return TypeContratResponseDTO.buildFromEntity(typeContratRepository.save(tc));
    }

    @Override
    public List<TypeContratResponseDTO> getAllTypCon() {
        return TypeContratResponseDTO.buildFromEntityList(typeContratRepository.findAll());
    }

    @Override
    public TypeContratResponseDTO getTypConById(Long id) {
        return TypeContratResponseDTO.buildFromEntity(typeContratRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Aucun type de Contrat trouvé")));
    }

    @Override
    public TypeContratResponseDTO updateTypConById(TypeContratRequestDTO typeContratRequestDTO) {
                TypeContrat typeContratToSave = typeContratRepository.findById(typeContratRequestDTO.getId())
                        .map(tc -> {
                            tc.setDescription(typeContratRequestDTO.getDescription());
                            tc.setTypecontrat(typeContratRequestDTO.getTypecontrat());
                            return typeContratRepository.save(tc);
                        }).orElseThrow(()->new RuntimeException("Aucun employer trouvé"));

        return TypeContratResponseDTO.buildFromEntity(typeContratRepository.save(typeContratToSave));
    }

    @Override
    public String deleteTypConById(Long id) {
        typeContratRepository.deleteById(id);
        return "type de contrat supprimé";
    }
}
