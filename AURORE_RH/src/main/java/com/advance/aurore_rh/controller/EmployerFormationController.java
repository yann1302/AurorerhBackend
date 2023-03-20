package com.advance.aurore_rh.controller;

import com.advance.aurore_rh.dto.request.EmployerFormationRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.EmployerFormationResponseDTO;
import com.advance.aurore_rh.model.Employer;
import com.advance.aurore_rh.service.inter.EmployerFormationServiceInter;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employerFormation")
@CrossOrigin(origins = {"*"})
public class EmployerFormationController {
    private final EmployerFormationServiceInter employerFormationServiceInter;

    public EmployerFormationController(EmployerFormationServiceInter employerFormationServiceInter) {
        this.employerFormationServiceInter = employerFormationServiceInter;
    }


    @PostMapping("/create")
    @ApiOperation("creation d'un nouvel employerFormation")
    public ResponseEntity<ApiResponse<EmployerFormationResponseDTO>> createEmplForm(@RequestBody EmployerFormationRequestDTO employerFormationRequestDTO){
        return ResponseEntity.ok(ApiResponse.<EmployerFormationResponseDTO>builder()
                .code(200)
                .sucsess(true)
                .message("operation effectuée")
                .data(employerFormationServiceInter.createEmplForm(employerFormationRequestDTO))
        .build());
    }

    @GetMapping("/read")
    @ApiOperation("Api qui permet le listing de tout les employersformation")
    public ResponseEntity<ApiResponse<List<EmployerFormationResponseDTO>>> getAllEmplForm(){
     return ResponseEntity.ok(ApiResponse.<List<EmployerFormationResponseDTO>>builder()
             .sucsess(true)
             .code(200)
             .message("operation effectuée")
             .data(employerFormationServiceInter.getAllEmplForm())
     .build());
    }

    @GetMapping("/read/{id}")
    @ApiOperation("api de listing d'un employerformation par l'id ")
    public ResponseEntity<ApiResponse<EmployerFormationResponseDTO>> getEmplFormById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<EmployerFormationResponseDTO>builder()
                .code(200)
                .message("operation effectuee")
                .sucsess(true)
                .data(employerFormationServiceInter.getEmplFormById(id))
        .build());
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("suppression d'un employerformation")
    public ResponseEntity<ApiResponse<String>> deleteEmplForm(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<String>builder()
                 .code(200)
                .sucsess(true)
                .message("operation effectuée")
                .data(employerFormationServiceInter.deleteEmplForm(id))
        .build());
    }
}
