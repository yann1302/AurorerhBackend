package com.advance.aurore_rh.controller;


import com.advance.aurore_rh.dto.request.TypeContratRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.TypeContratResponseDTO;
import com.advance.aurore_rh.service.inter.TypeContratServiceInter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type de contrat")
@CrossOrigin("*")
public class TypeContratController {
    @Autowired
    public final TypeContratServiceInter typeContratServiceInter;

    public TypeContratController(TypeContratServiceInter typeContratServiceInter) {
        this.typeContratServiceInter = typeContratServiceInter;
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("suppresion d'une type de sanction")

    public ResponseEntity<ApiResponse<String>> deleteTypConById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .data(typeContratServiceInter.deleteTypConById(id))
                .message("suppresion reuissi")
                .build());
    }

    @PutMapping("/update/{id}/")
    @ApiOperation("modification d'un type de contrat")
    public ResponseEntity<ApiResponse<TypeContratResponseDTO>> updateSanct(@RequestBody TypeContratRequestDTO typeContratRequestDTO){
        return ResponseEntity.ok(ApiResponse.<TypeContratResponseDTO>builder()
                .sucsess(true)
                .message("modification d'un type de contrat effectuer")
                .data(typeContratServiceInter.updateTypConById(typeContratRequestDTO))
                .build());
    }

    @PostMapping("/create")
    @ApiOperation("creation d'un nouveau type de contrat")

    public ResponseEntity<ApiResponse<TypeContratResponseDTO>> createTypCon(@RequestBody TypeContratRequestDTO typeContratRequestDTO){
        return ResponseEntity.ok(ApiResponse.<TypeContratResponseDTO>builder()
                .message("Opération effectuée")
                .sucsess(true)
                .data(typeContratServiceInter.createTypCon(typeContratRequestDTO))
                .build());
    }

    @GetMapping("/read")
    @ApiOperation("Api qui permet le listing de tout les type de contrat")

    public ResponseEntity<ApiResponse <List<TypeContratResponseDTO>>> getAllTypCon(){
        return ResponseEntity.ok(ApiResponse.<List<TypeContratResponseDTO>>builder()
                .sucsess(true)
                .message("Opération effectuée")
                .data(typeContratServiceInter.getAllTypCon())
                .build());
    }


    @GetMapping("/read/{id}")
    @ApiOperation("api de listing d'un type de contrat par id ")
    public ResponseEntity<ApiResponse<TypeContratResponseDTO>> getTypConById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<TypeContratResponseDTO>builder()
                .data(typeContratServiceInter.getTypConById(id))
                .message("Opération effectuée")
                .sucsess(true)
                .build());

    }
}
