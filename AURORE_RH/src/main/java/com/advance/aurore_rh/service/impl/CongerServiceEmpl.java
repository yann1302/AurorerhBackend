package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.CongerRequestDTO;
import com.advance.aurore_rh.dto.response.CongerResponseDTO;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import com.advance.aurore_rh.dto.response.SanctionResponseDTO;
import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.repository.CongerRepository;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.service.inter.CongerServiceInter;
import com.advance.aurore_rh.utils.StatutConger;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
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
       // LocalDate = new LocalDate();

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

        Date curentDate= new Date();
        if (curentDate.after(congerRequestDTO.getDate_debut()) && curentDate.before(congerRequestDTO.getDate_fin() )
        ) {
            congerRequestDTO.setStatut(StatutConger.EN_COURS.getValue());
        }

        else if (  curentDate.after(congerRequestDTO.getDate_fin())){
            congerRequestDTO.setStatut(StatutConger.TERMINER.getValue());
        }

        Employer employer = employerRepository.findById(congerRequestDTO.getId_Employer())
                .orElseThrow(() -> new RuntimeException("Aucun employer trouvé avec cette id"));
        Conger c =congerRequestDTO.buildFromDto(congerRequestDTO, employer);
        return CongerResponseDTO.buildFromEntity(congerRepository.save(c));
    }

    @Override
    public List<CongerResponseDTO> getAllConger() {
        return CongerResponseDTO.buildFromEntity(congerRepository.findAll());
    }

    @Override
    public CongerResponseDTO getCongetById(Long id) {
        return CongerResponseDTO.buildFromEntity(congerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Aucune santion trouvé")));

    }

    @Override
    public String deleteCongerById(Long id) {
        congerRepository.deleteById(id);
        return "conger supprimé";
    }
}
