package com.advance.aurore_rh.controller;

import com.advance.aurore_rh.dto.request.NoteProfessionelRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.NoteProfessionelResponseDTO;
import com.advance.aurore_rh.service.inter.NoteProfessionelServiceInter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noteProfessionel")
@CrossOrigin("*")
public class NoteProfessionelController {
    @Autowired
    private final NoteProfessionelServiceInter noteProfessionelServiceInter;

    public NoteProfessionelController(NoteProfessionelServiceInter noteProfessionelServiceInter) {
        this.noteProfessionelServiceInter = noteProfessionelServiceInter;
    }

    @PostMapping("/create")
    @ApiOperation("creation d'une nouvelle note Professionel ")
    public ResponseEntity<ApiResponse<NoteProfessionelResponseDTO>> createEmpl(@RequestBody NoteProfessionelRequestDTO noteProfessionelRequestDTO){
        return ResponseEntity.ok(ApiResponse.<NoteProfessionelResponseDTO>builder()
                .message("creation dune note professionel effectuer")
                .code(200)
                .sucsess(true)
                .data(noteProfessionelServiceInter.createEmpl(noteProfessionelRequestDTO))
        .build());
    }

    @GetMapping("/read")
    @ApiOperation("Api qui permet le listing de tout les employers")
    public ResponseEntity<ApiResponse<List<NoteProfessionelResponseDTO>>> getAllEmpl(
            @RequestParam(name = "token",defaultValue ="") String token,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ){
        return ResponseEntity.ok(ApiResponse.<List<NoteProfessionelResponseDTO>>builder()
                .sucsess(true)
                .code(200)
                .message("lecture de toute les notes professionelles")
                .data(noteProfessionelServiceInter.getAllEmpl())
        .build());
    }

    @GetMapping("/read/{id}")
    @ApiOperation("api de listing d'une note professionelle par l'id ")
    public ResponseEntity<ApiResponse<NoteProfessionelResponseDTO>> getEmplById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<NoteProfessionelResponseDTO>builder()
                .message("lecture des details de la note professionelle effectuée")
                .code(200)
                .sucsess(true)
                .data(noteProfessionelServiceInter.getEmplById(id))
                .build());
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Suppression d'une note professionel")
    public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .message("suppresion de la note professionelle effectuée")
                .code(200)
                .sucsess(true)
                .data(noteProfessionelServiceInter.deleteById(id))
                .build());
    }
}
