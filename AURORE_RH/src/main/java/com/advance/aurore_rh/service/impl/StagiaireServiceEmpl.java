package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.dto.request.StagiaireRequestDTO;
import com.advance.aurore_rh.dto.response.SanctionResponseDTO;
import com.advance.aurore_rh.dto.response.StagiaireResponseDTO;
import com.advance.aurore_rh.exceptions.BadRequestException;
import com.advance.aurore_rh.model.Numerotation;
import com.advance.aurore_rh.model.Sanction;
import com.advance.aurore_rh.model.Stagiaire;
import com.advance.aurore_rh.repository.NumerotationRepository;
import com.advance.aurore_rh.repository.StagiaireRepository;
import com.advance.aurore_rh.service.inter.StagiaireServiceInter;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

@Service

public class StagiaireServiceEmpl implements StagiaireServiceInter {

    @Autowired
    StagiaireRepository stagiaireRepository;

    @Autowired
    NumerotationRepository numerotationRepository;

    @Override
    public StagiaireResponseDTO creatStag(StagiaireRequestDTO stagiaireRequestDTO) {
        if(Objects.nonNull(stagiaireRequestDTO.getId()) &&  stagiaireRequestDTO.getId() > 0 ){
            Stagiaire stagiaireToSave = stagiaireRepository.findById(stagiaireRequestDTO.getId())
                    .map( e -> {
                    e.setPhoto(stagiaireRequestDTO.getPhoto());
                    e.setAdresse(stagiaireRequestDTO.getAdresse());
                    e.setAnnee_academique(stagiaireRequestDTO.getAnnee_academique());
                    e.setDate_debut(stagiaireRequestDTO.getDate_debut());
                    e.setDate_fin(stagiaireRequestDTO.getDate_fin());
                    e.setDepartement(stagiaireRequestDTO.getDepartement());
                    e.setDate_naissance(stagiaireRequestDTO.getDate_naissance());
                    e.setEcole(stagiaireRequestDTO.getEcole());
                    e.setLieu_naissance(stagiaireRequestDTO.getLieu_naissance());
                    e.setDuree(stagiaireRequestDTO.getDuree());
                    e.setMatricule(stagiaireRequestDTO.getMatricule());
                    e.setPrenom(stagiaireRequestDTO.getPrenom());
                    e.setNom(stagiaireRequestDTO.getNom());
                    e.setNationalite(stagiaireRequestDTO.getNationalite());
                    e.setSexe(stagiaireRequestDTO.getSexe());
                    e.setStatut_matrimoniale(stagiaireRequestDTO.getStatut_matrimoniale());
                    e.setNumero(stagiaireRequestDTO.getNumero());
                        //e.setSanctions(stagiaireRequestDTO.getSanctions());
                        return stagiaireRepository.save(e);}
                    ).orElseThrow(()->new RuntimeException("Aucun stagiaire trouvé"));
            return StagiaireResponseDTO.buildFromEntity(stagiaireToSave);
        }
        //stagiaireRequestDTO.setCodeStage(getCodeCourant());
        Stagiaire s = stagiaireRequestDTO.buildFromDto(stagiaireRequestDTO);
        return StagiaireResponseDTO.buildFromEntity(stagiaireRepository.save(s));
    }

//    public String getCodeCourant() {
//        Numerotation numerotation = numerotationRepository.findByCode("CODE_STAGE").orElse(null);
//        if (Objects.isNull(numerotation))
//            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Configuration requise", "aucune configuration n'as ete definir pour la souche de numérotation de : ARTICLE");
//        //assert numerotation != null;
//        int fin = numerotation.getSouche().indexOf("00");
//        String codeUser, prefix = ((fin > 0) ? numerotation.getSouche().substring(0, fin) : numerotation.getSouche());
//        codeUser = prefix.concat(new DecimalFormat("00000").format(numerotation.getNumeroIndex())).toUpperCase();
//
//        while (stagiaireRepository.existsByCodeStage(codeUser)) {
//            numerotation.setNumeroIndex(numerotation.getNumeroIndex() + 1);
//            numerotation = numerotationRepository.save(numerotation);
//            codeUser = prefix.concat(new DecimalFormat("00000").format(numerotation.getNumeroIndex())).toUpperCase();
//        }
//
//        return codeUser;
//    }

    @Override
    public List<StagiaireResponseDTO> getAllStag() {
        return StagiaireResponseDTO.builFromEntityList(stagiaireRepository.findAll());
    }

    @Override
    public StagiaireResponseDTO getStagById(Long id) {
        return StagiaireResponseDTO.buildFromEntity(stagiaireRepository.findById(id)
                .orElseThrow(()->new RuntimeException("aucun stagiaire trouvé ")));
    }

    @Override
    public String deleteStagById(Long id) {
        stagiaireRepository.deleteById(id);
        return "saction supprimé";
    }
}
