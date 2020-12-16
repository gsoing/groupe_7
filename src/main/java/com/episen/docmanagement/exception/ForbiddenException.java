package com.episen.docmanagement.exception;

import com.episen.docmanagement.dto.Message;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends AbstractException {

    public static final ForbiddenException DEFAULT = new ForbiddenException();

    public static final String FORBIDDEN_CODE = "err.func.wired.forbidden";
    public static final String FORBIDDEN_MESSAGE = "Vous ne possédez pas les droits pour accéder à cette ressource";

    private ForbiddenException() {
        super(HttpStatus.FORBIDDEN,
                Message.builder().build().builder()
                        .code(FORBIDDEN_CODE)
                        .message(FORBIDDEN_MESSAGE)
                        .build());
    }
}
