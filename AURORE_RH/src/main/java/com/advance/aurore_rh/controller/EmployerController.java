package com.advance.aurore_rh.controller;


import com.advance.aurore_rh.dto.request.EmployerRequestDTO;
import com.advance.aurore_rh.dto.request.UserEmployerRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.EmployerResponseDTO;
import com.advance.aurore_rh.service.inter.ActiviteServiceInter;
import com.advance.aurore_rh.service.inter.EmployerServiceinter;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employer")
@CrossOrigin(origins = {"*"})
public class    EmployerController {

    private final EmployerServiceinter employerServiceinter;

    public EmployerController(EmployerServiceinter employerServiceinter) {
        this.employerServiceinter = employerServiceinter;

    }
    @Autowired
    ActiviteServiceInter activiteServiceInter;


    @PutMapping("/update/{id}/")
    @ApiOperation("Api modification d'un employer")
    public ResponseEntity<ApiResponse<EmployerResponseDTO>>  updateEmpl(@RequestBody EmployerRequestDTO employerRequestDTO){

        return ResponseEntity.ok(ApiResponse.<EmployerResponseDTO>builder()
                .sucsess(true)
                .message("Opération effectuée")
                .code(200)
                .data(employerServiceinter.updateEmpl(employerRequestDTO))
        .build());
//    public EmployerResponseDTO update(@RequestBody EmployerRequestDTO employerRequestDTO) {
//        return employerServiceinter.updateEmpl(employerRequestDTO);
    }

    @PostMapping("/create")
    @ApiOperation("creation d'un nouvel employer")
    public ResponseEntity<ApiResponse<EmployerResponseDTO>> createEmpl(@RequestBody UserEmployerRequestDTO userEmployerRequestDTO
           // , HttpServletRequest request
    ){
       // activiteServiceInter.Sauvegarde(request, "creation d'un employé", "dto","EmployerController| create | chemin: /employer/create");
        return ResponseEntity.ok(ApiResponse.<EmployerResponseDTO>builder()
                .message("Opération effectuée")
                .sucsess(true)
                .data(employerServiceinter.createEmpl(userEmployerRequestDTO))
                .code(200)
                .build());
//    public EmployerResponseDTO createEmpl(@RequestBody EmployerRequestDTO employerRequestDTO){
//        return employerServiceinter.createEmpl(employerRequestDTO);
    }

    @GetMapping("/read")
    @ApiOperation("Api qui permet le listing de tout les employers")
    public ResponseEntity<ApiResponse <Page<EmployerResponseDTO>>> getAllEmpl(
            @RequestParam(name = "token",defaultValue ="") String token,
            @RequestParam(name = "statut", defaultValue = "ACTIF") String statut,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
            , HttpServletRequest request
    ){
        ///activiteServiceInter.sauvegarde(request, "liste des employés", "token:" + token  + "statut:" +statut + "page:" + page + "size" + size ,"EmployerController| create | chemin: /employer/read");
        Pageable pageable = PageRequest.of(page,size);
        return ResponseEntity.ok(ApiResponse.<Page<EmployerResponseDTO>>builder()
                .sucsess(true)
                .message("Opération effectuée")
                .code(200)
               .data(employerServiceinter.getAllEmpl(token,statut,pageable))
        .build());

//    public List <EmployerResponseDTO> getAllEmpl(){
//        return employerServiceinter.getAllEmpl();
    }

    @GetMapping("/read/{id}")
    @ApiOperation("api de listing d'un employer par l'id ")
    public ResponseEntity<ApiResponse<EmployerResponseDTO>> getEmplById(@PathVariable Long id){

        return ResponseEntity.ok(ApiResponse.<EmployerResponseDTO>builder()
                .data(employerServiceinter.getEmplById(id))
                .message("Opération effectuée")
                .sucsess(true)
                .code(200)
                .build());

    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Suppression d'un employer")
    public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Long id  , HttpServletRequest request){
        activiteServiceInter.sauvegarde(request, "creation d'un employé", "null","EmployerController| delete | chemin: /employer/delete");
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .sucsess(true)
                .message("Opération effectuée")
                .data(employerServiceinter.deleteById(id))
                .code(200)
                .build());
//    public String delete(@PathVariable Long id) {
//        return employerServiceinter.delete(id);
    }
}
