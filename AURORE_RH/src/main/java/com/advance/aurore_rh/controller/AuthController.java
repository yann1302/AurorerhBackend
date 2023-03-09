package com.advance.aurore_rh.controller;

import com.advance.aurore_rh.dto.request.AuthenticateRequestDTO;
import com.advance.aurore_rh.dto.request.SignInRequestDTO;
import com.advance.aurore_rh.dto.response.ApiResponse;
import com.advance.aurore_rh.dto.response.AuthenticateResponseDTO;
import com.advance.aurore_rh.dto.response.SingInResponseDTO;
import com.advance.aurore_rh.service.auth.ApplicationUserService;
import com.advance.aurore_rh.service.auth.AuthService;
import com.advance.aurore_rh.utils.JwtUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")

public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ApplicationUserService userService;

    @Autowired
    private AuthService authService;
    @Autowired
    private JwtUtils jwtUtils;



    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody AuthenticateRequestDTO request){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            final UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
            final String jwt = jwtUtils.generateToken(userDetails.getUsername());

            userService.findByUserName(request.getUsername());
            AuthenticateResponseDTO data = AuthenticateResponseDTO.
                    builder()
                    .token(jwt)
                    .userResponseDto(  userService.findByUserName(request.getUsername()))
                    .build();
            return ResponseEntity.ok(ApiResponse.builder()
                    .data(data)
                    .message("login reuissi")
                    .sucsess(true)
                    .build());
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        }



    @PostMapping("/signIn")
    public ResponseEntity<ApiResponse<SingInResponseDTO>> signIn(@RequestBody SignInRequestDTO user){

        if (authService.existByEmail(user.getEmail()))
            throw new RuntimeException("cette addresse mail existe deja ");
        return ResponseEntity.ok(
                ApiResponse.<SingInResponseDTO>builder()
                .message("Enregistrement reuissie")
                .sucsess(true)
                .data(authService.createUser(user))
                .build()
        );

//        return ResponseEntity.ok(ApiResponse.builder()
//                .data(user.getUsername())
//                .sucsess(true)
//                .message("Operation effectuer")
//                .build());
//        //return ResponseEntity.ok(new ApiResponse(true,"operation effectuer", user.getUsername()));
    }

}
