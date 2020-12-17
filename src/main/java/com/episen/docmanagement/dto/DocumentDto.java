package com.episen.docmanagement.dto;

import com.episen.docmanagement.entity.Document;
import com.episen.docmanagement.repository.DocumentRepository;
import com.episen.docmanagement.service.DocumentService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class DocumentDto {

    //TODO: Pas utilisé
    private DocumentRepository documentRepository;
    private DocumentService documentService;

    //Lock optimiste
    public Document update(Document document, Document updateDoc){
        int version = document.getVersion();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        document.setEditor(username);

        document.setBody(updateDoc.getBody());
        document.setTitle(updateDoc.getTitle());
        document.setUpdated(LocalDateTime.now());
        if (version == document.getVersion()){
            document.setVersion(version+1);
            return document;
        } else {
            return null;
        }
    }

}
