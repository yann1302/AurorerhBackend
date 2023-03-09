package com.advance.aurore_rh.service.auth;


import com.advance.aurore_rh.dto.request.SignInRequestDTO;
import com.advance.aurore_rh.dto.response.SingInResponseDTO;
import com.advance.aurore_rh.model.User;

public interface AuthServiceInter {

     SingInResponseDTO createUser(SignInRequestDTO signInRequestDTO);

    SingInResponseDTO updateUser(SignInRequestDTO signInRequestDTO);

    String deleteUser(Long id);

    User findByEmail(String email);




}
