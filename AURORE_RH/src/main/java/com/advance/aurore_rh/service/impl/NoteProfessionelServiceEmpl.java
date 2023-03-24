package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.NoteProfessionelRequestDTO;
import com.advance.aurore_rh.dto.response.NoteProfessionelResponseDTO;
import com.advance.aurore_rh.model.NoteProfessionel;
import com.advance.aurore_rh.repository.NoteProfessionelRepository;
import com.advance.aurore_rh.service.inter.NoteProfessionelServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class NoteProfessionelServiceEmpl implements NoteProfessionelServiceInter {

    @Autowired
    NoteProfessionelRepository noteProfessionelRepository;

    @Override
    public NoteProfessionelResponseDTO createEmpl(NoteProfessionelRequestDTO noteProfessionelRequestDTO) {
        if(Objects.nonNull(noteProfessionelRequestDTO.getId()) &&  noteProfessionelRequestDTO.getId() > 0 ){
            NoteProfessionel npToSave = noteProfessionelRepository.findById(noteProfessionelRequestDTO.getId())
                    .map( e -> {
                        e.setDescription(noteProfessionelRequestDTO.getDescription());
                        e.setDate_publication(noteProfessionelRequestDTO.getDate_publication());
                        e.setPhoto(noteProfessionelRequestDTO.getPhoto());
                        e.setTheme(noteProfessionelRequestDTO.getTheme());


                        //e.setSanctions(noteProfessionelRequestDTO.getSanctions());
                        return noteProfessionelRepository.save(e);}
                    ).orElseThrow(()->new RuntimeException("Aucune sanction trouvé"));
            return NoteProfessionelResponseDTO.buildFromEntity(npToSave);
        }
        NoteProfessionel np = noteProfessionelRequestDTO.buildFromDto(noteProfessionelRequestDTO);
        return NoteProfessionelResponseDTO.buildFromEntity(noteProfessionelRepository.save(np));
    }

    @Override
    public Page<NoteProfessionelResponseDTO> getAllEmpl(String token, Pageable pageable) {
        return NoteProfessionelResponseDTO.buildFromEntityPage(noteProfessionelRepository.findAllByToken('%'+token+'%', pageable));
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
