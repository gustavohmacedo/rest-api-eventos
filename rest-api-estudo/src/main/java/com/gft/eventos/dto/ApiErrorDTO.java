package com.gft.eventos.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Setter
@Getter
public class ApiErrorDTO {

    private String message;
    private List<String> erros;
    private HttpStatus status;

    public ApiErrorDTO() {
    }

    public ApiErrorDTO(String message, List<String> erros, HttpStatus status) {
        this.message = message;
        this.erros = erros;
        this.status = status;
    }

    public ApiErrorDTO(String message, String error, HttpStatus status) {
        this.message = message;
        this.erros = List.of(error);
        this.status = status;
    }


}

