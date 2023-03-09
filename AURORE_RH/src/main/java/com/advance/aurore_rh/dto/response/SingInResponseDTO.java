package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.User;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SingInResponseDTO {
    private String resultat;
//    private String password;

    public static SingInResponseDTO buildFronEntity(User entity){
        return SingInResponseDTO.builder()
//                .password(entity.getPassword())
                .resultat(entity.getUsername())
                .build();


    }
}
