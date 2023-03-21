package com.advance.aurore_rh.controller;

import com.advance.aurore_rh.dto.request.ContratRequestDTO;
import com.advance.aurore_rh.dto.request.DemandeFormRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.ContratResponseDTO;
import com.advance.aurore_rh.dto.response.DemandeFormResponseDTO;
import com.advance.aurore_rh.service.inter.DemandeFormServiceInter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DemandeFormation")
@CrossOrigin("*")
public class DemandeFormController {

    @Autowired
    private final DemandeFormServiceInter demandeFormServiceInter;

    public DemandeFormController(DemandeFormServiceInter demandeFormServiceInter) {
        this.demandeFormServiceInter = demandeFormServiceInter;
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("suppression d'une demande de formation")
    public ResponseEntity<ApiResponse<String>> deleteDemande(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .sucsess(true)
                .code(200)
                .message("suppression du contrat reuissi")
                .data(demandeFormServiceInter.deleteDemande(id))
                .build());
    }

    @PostMapping("/create")
    @ApiOperation("creation d'un contrat ")
    public ResponseEntity<ApiResponse<DemandeFormResponseDTO>> createDemande(@RequestBody DemandeFormRequestDTO demandeFormRequestDTO) {
        return ResponseEntity.ok(ApiResponse.<DemandeFormResponseDTO>builder()
                .sucsess(true)
                .code(200)
                .message("creation contrat d'un employer")
                .data(demandeFormServiceInter.createDemande(demandeFormRequestDTO))
                .build());
    }

    @GetMapping("/read")
    @ApiOperation("Api de lecture de tout les contrats")
    public ResponseEntity<ApiResponse<List<DemandeFormResponseDTO>>> getAllDemande() {
        return ResponseEntity.ok(ApiResponse.<List<DemandeFormResponseDTO>>builder()
                .message("listing reuissi")
                .sucsess(true)
                .code(200)
                .data(demandeFormServiceInter.getAllDemande())
                .build());
    }

    @GetMapping("/read/{id}")
    @ApiOperation("Api de lecture d'un contrat par un id")
    public ResponseEntity<ApiResponse<DemandeFormResponseDTO>> getDemandeById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.<DemandeFormResponseDTO>builder()
                .sucsess(true)
                .message("contrat trouvé")
                .code(200)
                .data(demandeFormServiceInter.getDemandeById(id))
                .build()
        );
    }
}
