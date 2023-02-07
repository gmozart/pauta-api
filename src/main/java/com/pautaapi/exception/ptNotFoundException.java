package com.pautaapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ptNotFoundException extends RuntimeException {

    public ptNotFoundException() {
        super("Resource not found!");
    }
    public ptNotFoundException(String exception) {
        super(exception);
    }

}
