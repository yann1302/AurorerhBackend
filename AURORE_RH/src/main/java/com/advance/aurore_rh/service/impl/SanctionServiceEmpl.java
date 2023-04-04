package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.SanctionRequetDTO;
import com.advance.aurore_rh.dto.response.SanctionResponseDTO;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.model.Sanction;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.repository.SanctionRepository;
import com.advance.aurore_rh.service.inter.SanctionServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Service
@AllArgsConstructor

public class SanctionServiceEmpl implements SanctionServiceInter {


    @Autowired
    SanctionRepository sanctionRepository;
    @Autowired
    EmployerRepository employerRepository;

    @Override
    public SanctionResponseDTO creatsanct(SanctionRequetDTO sanctionRequetDTO) {
        if(Objects.nonNull(sanctionRequetDTO.getId()) &&  sanctionRequetDTO.getId() > 0 ){
            Sanction sanctionToSave = sanctionRepository.findById(sanctionRequetDTO.getId())
                    .map( e -> {
                        e.setDescription(sanctionRequetDTO.getDescription());
                        e.setStatut(sanctionRequetDTO.getStatut());
                        e.setDebut_sanction(sanctionRequetDTO.getDebut_sanction());
                        e.setFin_sanction(sanctionRequetDTO.getFin_sanction());
                        e.setStatut(sanctionRequetDTO.getStatut());
                        e.setType_sanction(sanctionRequetDTO.getType_sanction());
                        //e.setSanctions(sanctionRequetDTO.getSanctions());
                        return sanctionRepository.save(e);}
                    ).orElseThrow(()->new RuntimeException("Aucune sanction trouvé"));
            return SanctionResponseDTO.buildFromEntity(sanctionToSave);
        }


        if (sanctionRequetDTO.getDebut_sanction().compareTo(sanctionRequetDTO.getFin_sanction()) > 0) {
            throw new RuntimeException("La date de début ne peut pas être après la date de fin.");
        }
//
//        try {
//            // Obtenez la date du champ debut_sanction
//            Date debutSanction = sanctionRequetDTO.getDebut_sanction();
//
//            // Créez un formateur de date avec le motif souhaité
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//            // Formatez la date en tant que chaîne avec le formateur
//            String debutSanctionFormatted = dateFormat.format(debutSanction);
//
//            // Utilisez la chaîne formattée comme date de début de la sanction
//            sanctionRequetDTO.setDebut_sanction(dateFormat.parse(debutSanctionFormatted));
//        } catch (ParseException e) {
//            throw new RuntimeException("Impossible de formater la date : " + e.getMessage(), e);
//        }

        Employer employer = employerRepository.findById(sanctionRequetDTO.getId_Employer())
        .orElseThrow(() -> new RuntimeException("Aucun employé trouvé avec cette id"));
        Sanction s = sanctionRequetDTO.buildFromDto(sanctionRequetDTO, employer);
        return SanctionResponseDTO.buildFromEntity(sanctionRepository.save(s));
    }

    @Override
    public Page<SanctionResponseDTO> getAllsanct(String token, Pageable pageable) {
        return SanctionResponseDTO.buildFromEntityPage(sanctionRepository.findAllByToken('%'+token+'%', pageable));
    }

    @Override
    public SanctionResponseDTO getSanctById(Long id) {
       return SanctionResponseDTO.buildFromEntity(sanctionRepository.findById(id)
               .orElseThrow(()->new RuntimeException("Aucune santion trouvé")));

    }

    @Override
    public SanctionResponseDTO updateSanct(SanctionRequetDTO sanctionRequetDTO) {
        Sanction sanctionToSave = sanctionRepository.findById(sanctionRequetDTO.getId())
                .map(s -> {
                    s.setDebut_sanction(sanctionRequetDTO.getDebut_sanction());
                    s.setFin_sanction(sanctionRequetDTO.getFin_sanction());
                    s.setDescription(sanctionRequetDTO.getDescription());
                    s.setType_sanction(sanctionRequetDTO.getType_sanction());
                    return sanctionRepository.save(s);

                }).orElseThrow(()->new RuntimeException("Aucun contrat trouvé"));
        return SanctionResponseDTO.buildFromEntity(sanctionToSave);

    }

    @Override
    public String deletesanctById(Long id) {
        sanctionRepository.deleteById(id);
        return "sanction supprimé";
    }
}
