package com.gft.eventos.exception;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventoException extends RuntimeException {

    private String message;

    public EventoException(String message) {
        super(message);
        this.message = message;
    }


}
