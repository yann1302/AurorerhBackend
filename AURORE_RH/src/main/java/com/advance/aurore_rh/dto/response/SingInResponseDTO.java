package com.advance.aurore_rh.dto.response;

import com.advance.aurore_rh.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;


@Data
@Builder
public class SingInResponseDTO {
    private String resultat;
    private String email;
    private Long id;
//    private String password;

    public static SingInResponseDTO buildFronEntity(User entity){
        return SingInResponseDTO.builder()
//                .password(entity.getPassword())
                .resultat(entity.getUsername())
                .email(entity.getEmail())
                .id(entity.getCreate_id())
                .build();


    }


}
