package com.episen.docmanagement.dto;


import com.episen.docmanagement.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    @Id
    private String id;
    private String nickname;
    private String mail;

    public User toEntity() {
        return User.builder()
                .id(id)
                .mail(mail)
                .nickname(nickname)
                .build();
    }
}
