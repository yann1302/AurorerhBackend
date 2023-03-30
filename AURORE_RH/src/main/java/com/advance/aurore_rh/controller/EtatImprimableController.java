package com.advance.aurore_rh.controller;

import com.advance.aurore_rh.dto.request.ReportParametersDTO;
import com.advance.aurore_rh.service.impl.SimpleReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/etat")
@CrossOrigin(origins = {"*"})
public class EtatImprimableController {

    @Autowired
    SimpleReportService simpleReportService;


    @PostMapping(value = "/etat/imprimer")
    public ResponseEntity<byte[]> imprimerEtats(@RequestBody ReportParametersDTO reportParametersDTO) throws SQLException, IOException, JRException {
        return simpleReportService.imprimerEtat(reportParametersDTO);
    }

}
