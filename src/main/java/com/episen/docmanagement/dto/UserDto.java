package com.episen.docmanagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private String username;
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }
}