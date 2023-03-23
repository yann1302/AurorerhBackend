package com.advance.aurore_rh.controller;

import com.advance.aurore_rh.dto.request.StagiaireRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.StagiaireResponseDTO;
import com.advance.aurore_rh.model.Stagiaire;
import com.advance.aurore_rh.service.inter.StagiaireServiceInter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stagiaire")
@CrossOrigin("*")
public class StagiaireController {

    @Autowired
    private final StagiaireServiceInter stagiaireServiceInter;

    public StagiaireController(StagiaireServiceInter stagiaireServiceInter) {
        this.stagiaireServiceInter = stagiaireServiceInter;
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("suppresion d'un stagiaire")
    public ResponseEntity<ApiResponse<String>> deleteStagById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .message("suppresion du stagiaire reuissi ")
                .sucsess(true)
                .code(200)
                .data(stagiaireServiceInter.deleteStagById(id))
        .build());
    }

    @PostMapping("/create")
    @ApiOperation("creation d'un nouveau stagiaire")
    public ResponseEntity<ApiResponse<StagiaireResponseDTO>> creatStag(@RequestBody StagiaireRequestDTO stagiaireRequestDTO){
        return ResponseEntity.ok(ApiResponse.<StagiaireResponseDTO>builder()
                .code(200)
                .sucsess(true)
                .message("ajout du sagiaire reuissi")
                .data(stagiaireServiceInter.creatStag(stagiaireRequestDTO))
        .build()
        );
    }

    @GetMapping("/read")
    @ApiOperation("Api qui permet le listing de tout les stagiaire")
    public ResponseEntity<ApiResponse <List<StagiaireResponseDTO>>> getAllStag(
            @RequestParam(name = "token",defaultValue ="") String token,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ){
        return ResponseEntity.ok(ApiResponse. <List<StagiaireResponseDTO>>builder()
                .message("liste de tout les stagiaire")
                .sucsess(true)
                .code(200)
                .data(stagiaireServiceInter.getAllStag())
        .build());
    }

    @GetMapping("/read/{id}")
    @ApiOperation("api de listing d'un stagiaire par l'id ")
    public ResponseEntity<ApiResponse<StagiaireResponseDTO>> getStagById(@PathVariable Long id ){
        return ResponseEntity.ok(ApiResponse.<StagiaireResponseDTO>builder()
                .code(200)
                .sucsess(true)
                .message("lecture du stagiaire reuissi")
                .data(stagiaireServiceInter.getStagById(id))
                .build());
    }

}
