package com.episen.documentmanagement.service;

import com.episen.documentmanagement.entity.Test;
import com.episen.documentmanagement.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public Test save(Test test) {
        return testRepository.save(test);
    }
}
