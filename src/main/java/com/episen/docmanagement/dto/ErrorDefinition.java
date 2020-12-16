package com.episen.docmanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
public class ErrorDefinition implements Serializable {
    private ErrorType type;
    private List<Message> messages;

    public ErrorDefinition(ErrorType type, Message...errorMessages){
        this.type = type;
        this.messages = Arrays.asList(errorMessages);
    }
}
