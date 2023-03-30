package com.advance.aurore_rh.controller;

import com.advance.aurore_rh.dto.request.EmployerFormationRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.EmployerFormationResponseDTO;
import com.advance.aurore_rh.dto.response.SessionsFormationResponseDTO;
import com.advance.aurore_rh.model.lnk.EmployerFormation;
import com.advance.aurore_rh.service.inter.EmployerFormationServiceInter;
import com.sun.tracing.dtrace.ProviderAttributes;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    @ApiOperation("creation d'une nouvelle Session de formation")
    public ResponseEntity<ApiResponse<EmployerFormationResponseDTO>> createEmplForm(@RequestBody EmployerFormationRequestDTO employerFormationRequestDTO){
        return ResponseEntity.ok(ApiResponse.<EmployerFormationResponseDTO>builder()
                .code(200)
                .sucsess(true)
                .message("operation effectuée")
                .data(employerFormationServiceInter.createEmplForm(employerFormationRequestDTO))
        .build());
    }

    @GetMapping("/read")
    @ApiOperation("Api qui permet le listing de toute les sessions de formation")
    public ResponseEntity<ApiResponse<List<SessionsFormationResponseDTO>>> getAllEmplForm(
//            @RequestParam(name = "token",defaultValue ="") String token,
//            @RequestParam(name = "page", defaultValue = "0") int page,
//            @RequestParam(name = "size", defaultValue = "10") int size
    ){

       // Pageable pageable = PageRequest.of(page,size);
     return ResponseEntity.ok(ApiResponse.<List<SessionsFormationResponseDTO>>builder()
             .sucsess(true)
             .code(200)
             .message("operation effectuée")
             .data(employerFormationServiceInter.getAllEmplForm())
     .build());
    }

    @GetMapping("/read/{reference}")
    @ApiOperation("api de listing des informations d'une session de formation ")
    public ResponseEntity<ApiResponse<EmployerFormationResponseDTO>> getEmplFormById(@PathVariable String reference){
        return ResponseEntity.ok(ApiResponse.<EmployerFormationResponseDTO>builder()
                .code(200)
                .message("operation effectuee")
                .sucsess(true)
                .data(employerFormationServiceInter.getEmplFormByReference(reference))
        .build());
    }

    @DeleteMapping("/delete/{reference}")
    @ApiOperation("suppression d'une session de formation")
    public ResponseEntity<ApiResponse<String>> deleteEmplForm(@PathVariable String reference){
        return ResponseEntity.ok(ApiResponse.<String>builder()
                 .code(200)
                .sucsess(true)
                .message("operation effectuée")
                .data(employerFormationServiceInter.deleteEmplForm(reference))
        .build());
    }
}
