package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.NoteProfessionelRequestDTO;
import com.advance.aurore_rh.dto.response.NoteProfessionelResponseDTO;
import com.advance.aurore_rh.model.NoteProfessionel;
import com.advance.aurore_rh.repository.NoteProfessionelRepository;
import com.advance.aurore_rh.service.inter.NoteProfessionelServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteProfessionelServiceEmpl implements NoteProfessionelServiceInter {

    @Autowired
    NoteProfessionelRepository noteProfessionelRepository;

    @Override
    public NoteProfessionelResponseDTO createEmpl(NoteProfessionelRequestDTO noteProfessionelRequestDTO) {
        NoteProfessionel np = noteProfessionelRequestDTO.buildFromDto(noteProfessionelRequestDTO);
        return NoteProfessionelResponseDTO.buildFromEntity(noteProfessionelRepository.save(np));
    }

    @Override
    public List<NoteProfessionelResponseDTO> getAllEmpl() {
        return NoteProfessionelResponseDTO.buildFromEntity(noteProfessionelRepository.findAll());
    }

    @Override
    public NoteProfessionelResponseDTO getEmplById(Long id) {
        return NoteProfessionelResponseDTO.buildFromEntity(noteProfessionelRepository.findById(id)
        .orElseThrow(()->new RuntimeException("aucune note professionel disponible")));
    }

    @Override
    public String deleteById(Long id) {
        noteProfessionelRepository.deleteById(id);
        return "note professionel supprimé" ;
    }
}
