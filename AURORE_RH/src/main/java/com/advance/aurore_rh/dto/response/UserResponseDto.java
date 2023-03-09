package com.advance.aurore_rh.dto.response;


import com.advance.aurore_rh.model.User;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserResponseDto {
    private long create_id;

    private String username;

    private String email;


}
