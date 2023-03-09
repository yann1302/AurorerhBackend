package com.advance.aurore_rh.controller;

import com.advance.aurore_rh.dto.request.CongerRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.CongerResponseDTO;
import com.advance.aurore_rh.service.inter.CongerServiceInter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/conger")
@CrossOrigin("*")
public class CongerController {
    @Autowired
    private  final CongerServiceInter congerServiceInter;

    public CongerController(CongerServiceInter congerServiceInter) {
        this.congerServiceInter = congerServiceInter;
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("suppression d'un conger")
    public ResponseEntity<ApiResponse<String>> deleteCongerById(@PathVariable Long id){
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .message("suppresion de la sanction reuissi")
                .sucsess(true)
                .data(congerServiceInter.deleteCongerById(id))
                .code(200)
                .build());

    }

    @PostMapping("/create")
    @ApiOperation("creation d'un conger ")
    public ResponseEntity<ApiResponse<CongerResponseDTO>> createConger(@RequestBody CongerRequestDTO congerRequestDTO){
        return ResponseEntity.ok(ApiResponse.<CongerResponseDTO>builder()
                .code(200)
                .sucsess(true)
                .message("conger attribuer avec success")
                .data(congerServiceInter.createConger(congerRequestDTO))
                .build());
    }

    @GetMapping("/read")
    @ApiOperation("Api de lecture de tout les conger")
    public ResponseEntity<ApiResponse<List<CongerResponseDTO>>> getAllConger(){
        return ResponseEntity.ok(ApiResponse.<List<CongerResponseDTO>>builder()
                .message("liste des congers")
                .code(200)
                .sucsess(true)
                .data(congerServiceInter.getAllConger())
                .build());
    }


    @GetMapping("/read/{id}")
    @ApiOperation("Api de lecture d'un conger par un id")
    public ResponseEntity<ApiResponse<CongerResponseDTO>> getCongetById(@PathVariable Long id ){
        return ResponseEntity.ok(ApiResponse.<CongerResponseDTO>builder()
                .code(200)
                .sucsess(true)
                .message("operation efectuée")
                .data(congerServiceInter.getCongetById(id))
                .build());
    }
}
