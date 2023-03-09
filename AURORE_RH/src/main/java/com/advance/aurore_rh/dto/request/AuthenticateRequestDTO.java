package com.advance.aurore_rh.dto.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticateRequestDTO {

    private String Username;
    private String password;
}