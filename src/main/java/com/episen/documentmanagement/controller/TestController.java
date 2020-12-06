package com.episen.documentmanagement.controller;

import com.episen.documentmanagement.entity.Test;
import com.episen.documentmanagement.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins="*", allowedHeaders="*")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("")
    public Test createNewClient(@RequestBody Test test) {
        return testService.save(test);
    }
}
