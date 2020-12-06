package com.episen.docmanagement.service;

import com.episen.docmanagement.entity.User;
import com.episen.docmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User createUser(User user){
        User insertedUser = userRepository.insert(user);
        return insertedUser;
    }



}
