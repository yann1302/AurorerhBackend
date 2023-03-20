package com.advance.aurore_rh.controller;

import com.advance.aurore_rh.dto.request.FormationRequestDTO;
import com.advance.aurore_rh.dto.request.UserEmployerRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.ContratResponseDTO;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import com.advance.aurore_rh.dto.response.FormationResponseDTO;
import com.advance.aurore_rh.service.inter.FormationServiceInter;
import com.sun.deploy.nativesandbox.comm.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formation")
@CrossOrigin(origins = {"*"})
public class FormationController {

    private final FormationServiceInter formationServiceInter;

    public FormationController(FormationServiceInter formationServiceInter) {
        this.formationServiceInter = formationServiceInter;
    }

    @PostMapping("/create")
    @ApiOperation("creation d'une nouvelle formation")
    public ResponseEntity<ApiResponse<FormationResponseDTO>> creteForm(@RequestBody FormationRequestDTO formationRequestDTO){
        return ResponseEntity.ok(ApiResponse.<FormationResponseDTO>builder()
                .message("Opération effectuée")
                .sucsess(true)
                .data(formationServiceInter.creteForm(formationRequestDTO))
                .code(200)
                .build());
}

    @GetMapping("/read")
    @ApiOperation("Api de lecture de toute les formation")
  public ResponseEntity<ApiResponse<List<FormationResponseDTO>>> getAllForm(){
        return ResponseEntity.ok(ApiResponse.<List<FormationResponseDTO>>builder()
                .message("liste de toute les formations")
                .code(200)
                .sucsess(true)
                .data(formationServiceInter.getAllForm())
                .build());
    }

    @GetMapping("/read/{id}")
    @ApiOperation("Api de lecture d'une formation par un id")
    public ResponseEntity<ApiResponse<FormationResponseDTO>> getFormById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<FormationResponseDTO>builder()
                .code(200)
                .sucsess(true)
                .message("formation trouvée")
                .data(formationServiceInter.getFormById(id))
        .build());
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("suppression d'une formation")
    public ResponseEntity<ApiResponse<String>> deleteForm(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .code(200)
                .message("formation supprimée")
                .sucsess(true)
                .data(formationServiceInter.deleteForm(id))
        .build());
    }
}

