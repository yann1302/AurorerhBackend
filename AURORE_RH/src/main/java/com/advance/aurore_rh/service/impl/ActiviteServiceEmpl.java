package com.advance.aurore_rh.service.impl;

import com.advance.aurore_rh.model.Activite;
import com.advance.aurore_rh.repository.ActiviteRepository;
import com.advance.aurore_rh.service.inter.ActiviteServiceInter;
import com.advance.aurore_rh.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Service
public class ActiviteServiceEmpl implements ActiviteServiceInter {


    @Autowired
    ActiviteRepository activiteRepository;
    @Autowired
    JwtUtils jwtUtils;

    @Override
    public void Sauvegarde(HttpServletRequest request, String details, String parametres, String source) {
        String token = jwtUtils.getToken(request);
        Activite activite = Activite.builder()
                .parametres(parametres)
                .details(details)
                .source(source)
                .dateEvenement(LocalDateTime.now())
                .libelleRole("SYSTEM")
                .nomUtilisateur(jwtUtils.extractNomUser(token))
                .build();
        activiteRepository.save(activite);
    }
}
