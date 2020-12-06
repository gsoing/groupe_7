package com.episen.docmanagement.controller;


import com.episen.docmanagement.dto.UserDto;
import com.episen.docmanagement.entity.User;
import com.episen.docmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.concurrent.TimeUnit;

@Slf4j
@Validated
@RestController
@EnableWebMvc
@RequiredArgsConstructor
@RequestMapping(UserController.PATH)
@SuppressWarnings("unused")
public class UserController {

    public static final String PATH = "/api/v1/user";

    private final UserService userService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<UserDto>
    createUser(@RequestBody UserDto user, UriComponentsBuilder uriComponentsBuilder) {

        User createdUser = userService.createUser(user.toEntity());
        UriComponents uriComponents = uriComponentsBuilder.path(UserController.PATH.concat("/{id}"))
                .buildAndExpand(createdUser.getId());

        UserDto createdUserDto = createdUser.toDto();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(uriComponents.toUri())
                .body(createdUserDto);
    }
}

