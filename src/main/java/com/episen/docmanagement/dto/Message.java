package com.episen.docmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class Message implements Serializable {

    private String code;
    private String message;
}
