package com.episen.docmanagement.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Document {
    @Id
    private String documentId;

    private LocalDateTime created;

    private LocalDateTime updated;

    private String title;

    private String creator;

    private String editor;

    private String body;

    private Status status;

    public Document(String title, String creator, String editor, String body) {
        this.title = title;
        this.creator = creator;
        this.editor = editor;
        this.body = body;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
        this.status = Status.CREATED;
    }



    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime upadated) {
        this.updated = upadated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId='" + documentId + '\'' +
                ", created=" + created +
                ", upadated=" + updated +
                ", title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                ", editor='" + editor + '\'' +
                ", body='" + body + '\'' +
                ", status=" + status +
                '}';
    }
}
