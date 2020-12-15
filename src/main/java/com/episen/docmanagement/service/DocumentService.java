package com.episen.docmanagement.service;

import com.episen.docmanagement.entity.Document;
import com.episen.docmanagement.repository.DocumentRepository;
import javafx.scene.input.DataFormat;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    @Autowired
    public final DocumentRepository documentRepository;

    public JSONObject createJsonWithDocumentsDetails(int page, int pageSize){
        List<Document> documents = getListOnPageNumber(pageSize, page);
        JSONObject json = new JSONObject();
        json.put("page", page);
        json.put("nbElements", documents.size());
        json.put("data", documents);
        return json;
    }

    public JSONObject insertInMongo(Document document){
        documentRepository.insert(document);
        return createJsonWithDocumentsDetails(0, 10);
    }

    public List<Document> getListOnPageNumber(int pageSize, int page){
        int documentsSize = this.documentRepository.findAll().size();
        int nbPage = documentsSize / pageSize + 1;
        List<Document> documents = new ArrayList<>();
        int i = 0;
        int j = page;
        while (i < pageSize){
            documents.add(findAll().get(j));
            j++; i++;
        }
        return documents;
    }

    public List<Document> findAll(){
        return this.documentRepository.findAll();
    }

}
