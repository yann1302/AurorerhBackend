package com.advance.aurore_rh.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticateResponseDTO {
    private String token;
    private UserResponseDto userResponseDto;


}
