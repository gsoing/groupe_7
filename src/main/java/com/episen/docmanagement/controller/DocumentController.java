package com.episen.docmanagement.controller;

import com.episen.docmanagement.entity.Document;
import com.episen.docmanagement.service.DocumentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DocumentController.PATH)
@AllArgsConstructor
@Slf4j
@Controller
public class DocumentController {

    public static final String PATH = "/api/v1/documents";

    public DocumentService documentService;

    @PostMapping
    public JSONObject createDocument(@RequestBody Document document){
        return documentService.insertInMongo(document);
    }

    @GetMapping("/{pageSize}/{page}")
    public JSONObject findAll(@PathVariable(required = true) int page, @PathVariable(required = false) int pageSize){
        return documentService.createJsonWithDocumentsDetails(page, pageSize);
    }

    @GetMapping("/{documentId}")
    public Document findDocumentById(@PathVariable(required = true) String documentId){
        return documentService.getDocumentById(documentId);
    }

    @PutMapping("/{documentId}")
    public Document updateDocument(@PathVariable(required = true) String documentId, @RequestBody Document document){
        return documentService.updateDocument(documentId, document);
    }



}
