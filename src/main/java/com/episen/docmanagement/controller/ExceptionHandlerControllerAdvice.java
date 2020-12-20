package com.episen.docmanagement.controller;

import com.episen.docmanagement.dto.ErrorDefinition;
import com.episen.docmanagement.dto.ErrorType;
import com.episen.docmanagement.dto.Message;
import com.episen.docmanagement.exception.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.support.ExceptionMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Message errorMessage =  Message.builder().message(ex.getMessage()).code(BadRequestException.BAD_REQUEST_CODE).build();
        ErrorDefinition errorMessages = new ErrorDefinition(ErrorType.fromStatus(status), errorMessage);
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Message errorMessage =  Message.builder().message(ex.getMessage()).code(BadRequestException.BAD_REQUEST_CODE).build();
        ErrorDefinition errorMessages = new ErrorDefinition(ErrorType.fromStatus(status), errorMessage);
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }

}
