package com.episen.docmanagement.controller;

import com.episen.docmanagement.entity.Document;
import com.episen.docmanagement.service.DocumentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class DocumentController {

    public DocumentService documentService;

    @PostMapping("/documents")
    public Document createDocument(@RequestBody Document document){
        return documentService.insertInMongo(document);
    }

    @GetMapping("/documents")
    public List<Document> findAll(){
        return documentService.findAll();
    }
}
