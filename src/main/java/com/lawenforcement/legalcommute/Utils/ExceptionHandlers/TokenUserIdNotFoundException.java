package com.lawenforcement.legalcommute.Utils.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TokenUserIdNotFoundException extends RuntimeException {
    public TokenUserIdNotFoundException(String message) {
        super(message);
    }
}
