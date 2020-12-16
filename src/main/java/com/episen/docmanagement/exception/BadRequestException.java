package com.episen.docmanagement.exception;

import com.episen.docmanagement.dto.Message;
import org.springframework.http.HttpStatus;

public class BadRequestException extends AbstractException {
    public static final BadRequestException DEFAULT = new BadRequestException();

    public static final String BAD_REQUEST_CODE = "err.func.wired.badrequest";
    public static final String BAD_REQUEST_MESSAGE = "The request is bad formated";

    private BadRequestException() {
        super(HttpStatus.BAD_REQUEST,
                Message.builder()
                        .code(BAD_REQUEST_CODE)
                        .message(BAD_REQUEST_MESSAGE)
                        .build());
    }
}
