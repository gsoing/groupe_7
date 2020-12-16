package com.episen.docmanagement.exception;

import com.episen.docmanagement.dto.Message;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AbstractException extends RuntimeException {
    private final transient Message error;
    private final HttpStatus httpStatus;



    public AbstractException(HttpStatus httpStatus, Message error) {
        super(error.getMessage());
        this.error = error;
        this.httpStatus = httpStatus;
    }

    public AbstractException(Message errorMessage) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);
    }
}

