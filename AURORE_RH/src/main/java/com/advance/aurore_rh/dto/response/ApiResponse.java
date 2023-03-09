package com.advance.aurore_rh.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse<T> {

    private boolean sucsess;
    private String message;
    private Date timestamp;
    private T data;
    private int code;

//    public ApiResponse(boolean sucsess, String message, Object data ) {
//        this.sucsess = sucsess;
//        this.message = message;
//        this.timestamp = new Date();
//        this.data = data;
//
//    }


}
