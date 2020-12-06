package com.episen.docmanagement.entity;

import com.episen.docmanagement.dto.UserDto;
import lombok.*;
import org.springframework.data.annotation.*;

@Data
@Builder
public class User {
    @Id
    private String id;
    private String nickname;
    private String mail;

    public UserDto toDto(){
        return UserDto.builder()
                .id(id)
                .mail(mail)
                .nickname(nickname)
                .build();
    }

    public User(String id, String nickname, String mail) {
        this.id = id;
        this.nickname = nickname;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
