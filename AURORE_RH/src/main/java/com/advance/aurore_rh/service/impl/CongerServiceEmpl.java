package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.CongerRequestDTO;
import com.advance.aurore_rh.dto.response.CongerResponseDTO;
import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.repository.CongerRepository;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.service.inter.CongerServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor

public class CongerServiceEmpl implements CongerServiceInter {

    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    CongerRepository congerRepository;

    @Override
    public CongerResponseDTO createConger(CongerRequestDTO congerRequestDTO) {
        if(Objects.nonNull(congerRequestDTO.getId()) &&  congerRequestDTO.getId() > 0 ){
            Conger congerToSave = congerRepository.findById(congerRequestDTO.getId())
                    .map( e -> {
                        e.setDescription(congerRequestDTO.getDescription());
                        e.setStatut(congerRequestDTO.getStatut());
                        e.setType_conger(congerRequestDTO.getType_conger());
                        e.setDate_debut(congerRequestDTO.getDate_debut());
                        e.setValidation(congerRequestDTO.getValidation());
                        e.setDate_reprise(congerRequestDTO.getDate_reprise());
                        e.setDate_fin(congerRequestDTO.getDate_fin());

                        //e.setSanctions(congerRequestDTO.getSanctions());
                        return congerRepository.save(e);}
                    ).orElseThrow(()->new RuntimeException("Aucun congé trouvé"));
            return CongerResponseDTO.buildFromEntity(congerToSave);
        }

//        Date curentDate= new Date();
//        if (curentDate.after(congerRequestDTO.getDate_debut()) && curentDate.before(congerRequestDTO.getDate_fin() )
//        ) {
//            congerRequestDTO.setStatut(StatutConger.EN_COURS.getValue());
//        }
//
//        else if (  curentDate.after(congerRequestDTO.getDate_fin())){
//            congerRequestDTO.setStatut(StatutConger.TERMINER.getValue());
//        }
        // Vérifie si la date de début est avant la date de fin
        if (congerRequestDTO.getDate_debut().compareTo(congerRequestDTO.getDate_fin()) > 0) {
            throw new RuntimeException("La date de début ne peut pas être après la date de fin.");
        }

        Employer employer = employerRepository.findById(congerRequestDTO.getId_Employer())
                .orElseThrow(() -> new RuntimeException("Aucun employer trouvé avec cette id"));
        Conger c =congerRequestDTO.buildFromDto(congerRequestDTO, employer);
        return CongerResponseDTO.buildFromEntity(congerRepository.save(c));
    }

    @Override
    public Page<CongerResponseDTO> getAllConger(String token, Pageable pageable) {
        return CongerResponseDTO.buildFromEntityPage(congerRepository.findAllByToken('%'+token+'%', pageable));
    }

    @Override
    public CongerResponseDTO getCongetById(Long id) {
        return CongerResponseDTO.buildFromEntity(congerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Aucun congé trouvé")));

    }

    @Override
    public String deleteCongerById(Long id) {
        congerRepository.deleteById(id);
        return "congé supprimé";
    }
}
