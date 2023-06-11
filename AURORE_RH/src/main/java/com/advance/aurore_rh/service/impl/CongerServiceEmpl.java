package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.CongerRequestDTO;
import com.advance.aurore_rh.dto.response.CongerResponseDTO;
import com.advance.aurore_rh.model.Conger;
import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.repository.CongerRepository;
import com.advance.aurore_rh.repository.ContratRepository;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.service.inter.CongerServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor

public class CongerServiceEmpl implements CongerServiceInter {

    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    CongerRepository congerRepository;

    @Autowired
    ContratRepository contratRepository;

//    @Override
//    public CongerResponseDTO createConger(CongerRequestDTO congerRequestDTO) {
//        if(Objects.nonNull(congerRequestDTO.getId()) &&  congerRequestDTO.getId() > 0 ){
//            // code mis à jour pour mettre à jour le congé existant
//            Conger congerToSave = congerRepository.findById(congerRequestDTO.getId())
//                    .map( e -> {
//                        e.setDescription(congerRequestDTO.getDescription());
//                        e.setStatut(congerRequestDTO.getStatut());
//                        e.setType_conger(congerRequestDTO.getType_conger());
//                        e.setDate_debut(congerRequestDTO.getDate_debut());
//                        e.setValidation(congerRequestDTO.getValidation());
//                        e.setDate_reprise(congerRequestDTO.getDate_reprise());
//                        e.setDate_fin(congerRequestDTO.getDate_fin());
//                        e.setJours(congerRequestDTO.getJours());
//
//                        //e.setSanctions(congerRequestDTO.getSanctions());
//                        return congerRepository.save(e);}
//                    ).orElseThrow(()->new RuntimeException("Aucun congé trouvé"));
//            return CongerResponseDTO.buildFromEntity(congerToSave);
//        }
//
//        if (congerRequestDTO.getDate_debut().compareTo(congerRequestDTO.getDate_fin()) > 0) {
//            throw new RuntimeException("La date de début ne peut pas être après la date de fin.");
//        }
//
//        Employer employer = employerRepository.findById(congerRequestDTO.getId_Employer())
//                .orElseThrow(() -> new RuntimeException("Aucun employer trouvé avec cette id"));
//
//        Contrat contrat = employer.getContrats().stream()
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Aucun contrat trouvé pour cet employé"));
//
//        Long joursRestants = contrat.getCongerAnnuel() - contrat.getJours_de_conges_pris();
//
//        if (congerRequestDTO.getJours() > joursRestants) {
//            throw new RuntimeException("Le nombre de jours demandés dépasse le nombre de jours de congé annuel restants.");
//        }
//
//        Conger c = congerRequestDTO.buildFromDto(congerRequestDTO, employer);
//        return CongerResponseDTO.buildFromEntity(congerRepository.save(c));
//    }

    @Override
    public CongerResponseDTO createConger(CongerRequestDTO congerRequestDTO) {
        if(Objects.nonNull(congerRequestDTO.getId()) &&  congerRequestDTO.getId() > 0 ){
            // code mis à jour pour mettre à jour le congé existant
            Conger congerToSave = congerRepository.findById(congerRequestDTO.getId())
                    .map( e -> {
                        e.setDescription(congerRequestDTO.getDescription());
                        e.setStatut(congerRequestDTO.getStatut());
                        e.setType_conger(congerRequestDTO.getType_conger());
                        e.setDate_debut(congerRequestDTO.getDate_debut());
                        e.setValidation(congerRequestDTO.getValidation());
                        e.setDate_reprise(congerRequestDTO.getDate_reprise());
                        e.setDate_fin(congerRequestDTO.getDate_fin());
                        e.setJours(congerRequestDTO.getJours());
                        e.setDureeMatern((congerRequestDTO.getDureeMatern()));
                        e.setDateDebutMatern(congerRequestDTO.getDateDebutMatern());
                        e.setDateFinMatern(congerRequestDTO.getDateFinMatern());

                        //e.setSanctions(congerRequestDTO.getSanctions());
                        return congerRepository.save(e);}
                    ).orElseThrow(()->new RuntimeException("Aucun congé trouvé"));
            return CongerResponseDTO.buildFromEntity(congerToSave);
        }

        if (congerRequestDTO.getDate_debut().compareTo(congerRequestDTO.getDate_fin()) > 0) {
            throw new RuntimeException("La date de début ne peut pas être après la date de fin.");
        }

        Employer employer = employerRepository.findById(congerRequestDTO.getId_Employer())
                .orElseThrow(() -> new RuntimeException("Aucun employer trouvé avec cette id"));

        Contrat contrat = employer.getContrats().stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Aucun contrat trouvé pour cet employé"));

        // initialiser getJours_de_conges_pris() à 0
        if (Objects.isNull(contrat.getJours_de_conges_pris())) {
            contrat.setJours_de_conges_pris(0);
        }

        int joursRestants = (int) (contrat.getCongerAnnuel() - contrat.getJours_de_conges_pris());

        if (congerRequestDTO.getJours() > joursRestants) {
            throw new RuntimeException("Le nombre de jours demandés dépasse le nombre de jours de congé annuel restants: " + joursRestants + ".");
        }

        Conger c = congerRequestDTO.buildFromDto(congerRequestDTO, employer);

        // mettre à jour getJours_de_conges_pris()
        contrat.setJours_de_conges_pris((int) (contrat.getJours_de_conges_pris() + congerRequestDTO.getJours()));
        employerRepository.save(employer);

        return CongerResponseDTO.buildFromEntity(congerRepository.save(c));
    }

    @Override
    public Page<CongerResponseDTO> getAllConger(String token, Pageable pageable) {
        return CongerResponseDTO.buildFromEntityPage(congerRepository.findAllByToken('%'+token+'%', pageable));
    }

//    @Override
//    public CongerResponseDTO getCongetById(Long id) {
//        return CongerResponseDTO.buildFromEntity(congerRepository.findById(id)
//                .orElseThrow(()->new RuntimeException("Aucun congé trouvé")));
//
//    }
@Override
public CongerResponseDTO getCongetById(Long id) {
        Conger conger = congerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Aucun congé trouvé"));
        List<Contrat> contratList = conger.getContrat();
    return CongerResponseDTO.buildFromEntityCon(conger, contratList);

}

    @Override
    public String deleteCongerById(Long id) {
        congerRepository.deleteById(id);
        return "congé supprimé";
    }
}
