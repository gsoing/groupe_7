package com.episen.docmanagement.service;

import com.episen.docmanagement.entity.Document;
import com.episen.docmanagement.repository.DocumentRepository;
import javafx.scene.input.DataFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    public final DocumentRepository documentRepository;

    public Document insertInMongo(Document document){
        return documentRepository.insert(document);
    }

    public List<Document> findAll(){
        return this.documentRepository.findAll();
    }

}
