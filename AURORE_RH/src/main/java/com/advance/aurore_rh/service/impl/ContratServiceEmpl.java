package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.ContratRequestDTO;
import com.advance.aurore_rh.dto.response.ContratResponseDTO;
import com.advance.aurore_rh.model.Contrat;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.repository.ContratRepository;
import com.advance.aurore_rh.repository.EmployerRepository;
import com.advance.aurore_rh.service.inter.ContratServiceInter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@AllArgsConstructor

public class ContratServiceEmpl implements ContratServiceInter {

    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EmployerRepository employerRepository;

    @Override
    public ContratResponseDTO createcontrat(ContratRequestDTO contratRequestDTO) {
        if(Objects.nonNull(contratRequestDTO.getId()) &&  contratRequestDTO.getId() > 0 ){
            Contrat contratToSave = contratRepository.findById(contratRequestDTO.getId())
                    .map( c -> {
                        c.setNom(contratRequestDTO.getNom());
                        c.setPrenom(contratRequestDTO.getPrenom());
                        c.setPoste(contratRequestDTO.getPoste());
                        c.setType_contrat(contratRequestDTO.getType_contrat());
                        c.setEtat_civil(contratRequestDTO.getEtat_civil());
                        c.setLieu_recrutememnt(contratRequestDTO.getLieu_recrutememnt());
                        c.setDebut_periode_essaie(contratRequestDTO.getDebut_periode_essaie());
                        c.setSalaire_brut(contratRequestDTO.getSalaire_brut());
                        c.setFin_periode_essaie(contratRequestDTO.getDate_embauche());
                        c.setLieu_travail(contratRequestDTO.getLieu_travail());
                        c.setDate_embauche(contratRequestDTO.getDate_embauche());
                        c.setPeriode_essaie(contratRequestDTO.getPeriode_essaie());
                        c.setStatut(contratRequestDTO.getStatut());
                        c.setDebut_essaie(contratRequestDTO.getDebut_essaie());
                        c.setFin_essaie(contratRequestDTO.getFin_essaie());
                        c.setCongerAnnuel(contratRequestDTO.getCongerAnnuel());

                        return  contratRepository.save(c);}
                    ).orElseThrow(()->new RuntimeException("Aucun contrat trouvé"));
            return ContratResponseDTO.buildFromEntity(contratToSave);
        }

//        Date curentDate= new Date();
//        if (curentDate.after(contratRequestDTO.getDebut_periode_essaie()) && curentDate.before(contratRequestDTO.getFin_periode_essaie())
//        ){
//            contratRequestDTO.setStatut(StatutContrat.EN_COURS.getValue());
//        }
//        else if (  curentDate.after(contratRequestDTO.getFin_periode_essaie())){
//            contratRequestDTO.setStatut(StatutConger.TERMINER.getValue());
//        }
        // Vérifie si la date de début est avant la date de fin
        if (contratRequestDTO.getDebut_periode_essaie().compareTo(contratRequestDTO.getFin_periode_essaie()) > 0) {
            throw new RuntimeException("La date de début ne peut pas être après la date de fin.");
        }
        else if(contratRequestDTO.getDebut_essaie().compareTo(contratRequestDTO.getFin_essaie()) > 0){
            throw new RuntimeException("La date de début ne peut pas être après la date de fin.");
        }

        Employer employer = employerRepository.findById(contratRequestDTO.getId_Employer())
                .orElseThrow(() -> new RuntimeException("Aucun employer trouvé avec cette id"));

        Contrat c = contratRequestDTO.buildFromDto(contratRequestDTO, employer);
        return ContratResponseDTO.buildFromEntity(contratRepository.save(c));
    }

    @Override
    public Page<ContratResponseDTO> getAllcontr(String token, Pageable pageable) {
        return ContratResponseDTO.buildFromEntityPage(contratRepository.findAllByToken('%'+token+'%', pageable));
    }

    @Override
    public ContratResponseDTO getcontrById(Long id) {

        return ContratResponseDTO.buildFromEntity(contratRepository.findById(id)
        .orElseThrow(()->new RuntimeException("Aucun contrat trouvé")));

    }

    @Override
    public ContratResponseDTO updateContr(ContratRequestDTO contratRequestDTO) {
        Contrat contratToSave = contratRepository.findById(contratRequestDTO.getId())
                .map( c -> {
                    c.setNom(contratRequestDTO.getNom());
                    c.setPrenom(contratRequestDTO.getPrenom());
                    c.setPoste(contratRequestDTO.getPoste());
                    c.setStatut(contratRequestDTO.getStatut());
                    c.setType_contrat(contratRequestDTO.getType_contrat());
                    c.setEtat_civil(contratRequestDTO.getEtat_civil());
                    c.setLieu_recrutememnt(contratRequestDTO.getLieu_recrutememnt());
                    c.setDebut_periode_essaie(contratRequestDTO.getDebut_periode_essaie());
                    c.setSalaire_brut(contratRequestDTO.getSalaire_brut());
                    c.setFin_periode_essaie(contratRequestDTO.getDate_embauche());
                    c.setLieu_travail(contratRequestDTO.getLieu_travail());
                    c.setDate_embauche(contratRequestDTO.getDate_embauche());
                    c.setPeriode_essaie(contratRequestDTO.getPeriode_essaie());

                    return  contratRepository.save(c);}

                ).orElseThrow(()->new RuntimeException("Aucun contrat trouvé"));
        return ContratResponseDTO.buildFromEntity(contratToSave);
    }

    @Override
    public String deleteContrById(Long id) {
        contratRepository.deleteById(id);
        return "contrat suprimé";
    }
}
