package com.advance.aurore_rh.controller;

import com.advance.aurore_rh.dto.request.SanctionRequetDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.CongerResponseDTO;
import com.advance.aurore_rh.dto.response.SanctionResponseDTO;
import com.advance.aurore_rh.service.inter.SanctionServiceInter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sanction")
@CrossOrigin("*")
public class SanctionController {

    @Autowired
    private final SanctionServiceInter sanctionServiceInter;

    public SanctionController(SanctionServiceInter sanctionServiceInter) {
        this.sanctionServiceInter = sanctionServiceInter;
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("suppresion d'une sanction")

    public ResponseEntity<ApiResponse<String>> deletesanctById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .sucsess(true)
                .code(200)
                .data(sanctionServiceInter.deletesanctById(id))
                .message("suppresion de la sanction reuissi")
        .build());
    }

    @PutMapping("/update/{id}/")
    @ApiOperation("modification d'une sanction")

    public ResponseEntity<ApiResponse<SanctionResponseDTO>> updateSanct(@RequestBody SanctionRequetDTO sanctionRequetDTO){
        return ResponseEntity.ok(ApiResponse.<SanctionResponseDTO>builder()
                .sucsess(true)
                .code(200)
                .message("modification de la sanction effectuer")
                .data(sanctionServiceInter.updateSanct(sanctionRequetDTO))
                .build());
    }


    @PostMapping("/create")
    @ApiOperation("creation d'une sanction")

    public ResponseEntity<ApiResponse<SanctionResponseDTO>> creatsanct(@RequestBody SanctionRequetDTO sanctionRequetDTO){
        return ResponseEntity.ok(ApiResponse.<SanctionResponseDTO>builder()
                .data(sanctionServiceInter.creatsanct(sanctionRequetDTO))
                .sucsess(true)
                .code(200)
                .message("ajout de la sanction reuissi")
                .build());
    }

    @GetMapping("/read")
    @ApiOperation("lecture de toute les sanctions")

    public ResponseEntity<ApiResponse<Page< SanctionResponseDTO>>> getAllsanct(
            @RequestParam(name = "token",defaultValue ="") String token,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ){
        Pageable pageable = PageRequest.of(page,size);
        return ResponseEntity.ok(ApiResponse.<Page<SanctionResponseDTO>>builder()
                .sucsess(true)
                .code(200)
                .message("liste de toute les sanctions")
                .data(sanctionServiceInter.getAllsanct(token, pageable))
                .build());
    }


    @GetMapping("/read/{id}")
    @ApiOperation("lecture de toute les sanctions")
    public ResponseEntity<ApiResponse<SanctionResponseDTO>> getSanctById(@PathVariable Long id ){
        return ResponseEntity.ok(ApiResponse.<SanctionResponseDTO>builder()
                .code(200)
                .sucsess(true)
                .code(200)
                .message("operation efectuée")
                .data(sanctionServiceInter.getSanctById(id))
                .build());
    }


}

