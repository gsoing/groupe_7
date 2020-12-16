package com.episen.docmanagement.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Lock {

    @Id
    private String documentId;
    private String owner;
    private String created;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Lock(String documentId, String owner, String created) {
        this.documentId = documentId;
        this.owner = owner;
        this.created = created;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "documentId='" + documentId + '\'' +
                ", owner='" + owner + '\'' +
                ", created=" + created +
                '}';
    }
}
